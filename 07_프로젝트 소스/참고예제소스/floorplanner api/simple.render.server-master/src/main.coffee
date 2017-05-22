fs = require 'fs'
path = require 'path'
express = require 'express'
body_parser = require 'body-parser'
multer = require 'multer'
nodemailer = require 'nodemailer'
Promise = require 'bluebird'
config = require 'config'
fml = require './fml'
sender2d = require './sender-2d'
sender3d = require './sender-3d'

DEFAULT_LOGO = "./public/uploads/inviso-footer.png"
SUCCESS_URL_2D = "#{config.SERVER}/render_complete"
SUCCESS_URL_3D = "#{config.SERVER}/render3d_complete"
REQUEST_TIMEOUT = 1000 * 60 * 15

log = require('./log').getLogger 'main', 'DEBUG'

render_complete = null
num_renders = 0
project_id = 0

storage = multer.diskStorage
  destination: (req, res, cb) ->
    cb null, "./public/uploads"
  filename: (req, file, cb) ->
    cb null, file.originalname

upload = multer
  storage: storage

transporter = nodemailer.createTransport()

mail_to = (to, uris) ->
  new Promise (resolve, reject) ->
    content = "renders for project #{project_id}:\n\n"
    content += "#{uris.join('\n\n')}\n\n"

    options =
      from: 'tim@floorplanner.com'
      to: to
      subject: "render - project #{project_id}"
      text: content

    transporter.sendMail options, (err, res) ->
      if err
        log.error "failed to send email to #{to}"
        log.error err
      else
        log.info "email was send to #{res.envelope.to.join(' ')}"
      resolve()

wait_for_render_complete = ->
  Promise.delay(500)
  .then ->
    if render_complete.length == num_renders
      render_complete
    else
      wait_for_render_complete()

cors = (req, res, next) ->
  res.header "Access-Control-Allow-Origin", "*"
  res.header "Access-Control-Allow-Headers",  "Cache-Control,Pragma,Origin,Authorization,Content-Type,X-Requested-With"
  res.header "Access-Control-Allow-Methods", "OPTIONS,GET,POST,PUT,DELETE"
  next()

router = new express.Router()

router.use cors
router.use body_parser.json()

router.get "/", (req, res) ->
  res.sendFile "index.html", {root:"./public"}

router.get "/css/*", (req, res) ->
  res.sendFile req.url, {root: "./public"}

router.get "/js/*", (req, res) ->
  res.sendFile req.url, {root: "./public"}

router.get "/logo/:filename", (req, res) ->
  logo = path.join "./public/uploads", req.params.filename
  if fs.existsSync(logo)
    log.info "serving logo #{req.params.filename}"
    res.sendFile logo, {root: "./"}
  else
    log.info "serving default logo #{DEFAULT_LOGO}"
    res.sendFile DEFAULT_LOGO, {root: "./"}

router.get "/logos", (req, res) ->
  fs.readdir "./public/uploads", (err, files) ->
    files.unshift "no logo"
    response = files.map (f) ->
      "<option value=\"#{f}\">#{f}</option>"
    res.end response.join("")

router.get "/render/design/:id/width/:width/height/:height/logo/:logo/recipient/:recipient/corner/:corner", (req, res) ->
  log.info "rendering design #{req.params.id}"
  log.debug req.params
  render_complete = []
  num_renders = 2
  req.params.success_url = SUCCESS_URL_2D
  req.params.logo = if req.params.logo == "default.png" then null else "#{req.params.logo}"
  sender2d(req.params)
  wait_for_render_complete().then ->
    res.json JSON.stringify(render_complete)

router.get "/render/project/:id/width/:width/height/:height/logo/:logo/recipient/:recipient/corner/:corner", (req, res) ->
  req.connection.setTimeout REQUEST_TIMEOUT
  log.info "rendering project #{req.params.id}"
  log.debug req.params
  fml.get_project_designs(req.params.id)
  .then (designs) ->
    render_complete = []
    num_renders = designs.length * 2
    project_id = req.params.id
    req.params.success_url = SUCCESS_URL_2D
    req.params.logo = if req.params.logo == "no logo" then null else "#{config.SERVER}/logo/#{req.params.logo}"
    sender3d(req.params)
    .then ->
      designs.forEach (id) ->
        options = JSON.parse JSON.stringify(req.params)
        options.id = id
        sender2d(options)
      wait_for_render_complete().then ->
        mail_to(req.params.recipient, render_complete)
        .then ->
          res.json JSON.stringify(render_complete)

router.post "/image/upload", upload.single('logo'), (req, res, next) ->
  log.info "logo #{req.file.originalname} uploaded"
  res.end "./logo/#{req.file.originalname}"

router.post "/render_complete", (req, res) ->
  log.info "2d render complete #{req.query.url}"
  render_complete.push req.query.url
  res.json {message: "ACK"}

router.post "/render3d_complete", (req, res) ->
  log.info "3d render complete"
  if req.body and req.body.images
    images = req.body.images.map (item) -> item.files.jpg
    render_complete = render_complete.concat images
  res.json {message: "ACK"}

app = express()
app.use "/", router

app.listen 5001

log.info "server running on port 5001"
