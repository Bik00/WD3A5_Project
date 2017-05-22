request = require 'request'
Promise = require 'bluebird'
AWS = require 'aws-sdk'

log = require('./log').getLogger 'sender-3d', 'DEBUG'

sqs = Promise.promisifyAll new AWS.SQS(region: process.env.AWS_EC2_REGION)

module.exports = ({id, success_url, width, height, logo, corner}) ->
  fetch_url = "http://www.floorplanner.com/designs/#{id}.xml"

  options =
    kind: "fp-render-2d"
    fetch_url: fetch_url
    success_url: success_url
    width: width
    height: height
    tracking:
      room_id: 0
      wl: ""

  if logo
    options.logo_info =
      file: logo
      corner: corner

  log.info "sending 2d render request for design #{id}"
  log.debug options

  sqs.getQueueUrlAsync(QueueName: process.env.WORKER_QUEUE)
  .then (data) ->
    #console.log data.QueueUrl
    #console.log JSON.stringify(options, null, "\t")
    message =
      MessageBody: JSON.stringify(options, null, "\t")
      QueueUrl: data.QueueUrl
      DelaySeconds: 0
    sqs.sendMessageAsync(message)
  .catch (err) ->
    console.error err
