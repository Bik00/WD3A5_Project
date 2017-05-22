request = require 'request'
et = require 'elementtree'
Promise = require 'bluebird'

if not process.env.FP_API_KEY
    console.error "environment var FP_API_KEY not set!"
    process.exit 0

AUTH = "Basic #{new Buffer(process.env.FP_API_KEY + ":" + "x").toString("base64")}"

load_project = (pid) ->
  new Promise (resolve, reject) ->
    options =
      url: "http://www.floorplanner.com/projects/#{pid}.xml"
      headers:
        "Authorization" : AUTH

    request.get options, (err, res, body) ->
      if err then return reject(err)
      resolve(body)

get_project_designs = (pid) ->
  load_project(pid)
  .then (body) ->
    doc = et.parse(body)
    doc.findall('floors/floor/designs/design/id').map (c) -> c.text

module.exports =
  get_project_designs: get_project_designs
