log4js = require 'log4js'
#config = require 'config'

###
PatternLayout
Format for specifiers is %[padding].[truncation][field]{[format]}
e.g. %5.10p - left pad the log level by 5 characters, up to a max of 10
Fields can be any of:
  - %r time in toLocaleTimeString format
  - %p log level
  - %c log category
  - %h hostname
  - %m log data
  - %d date in various formats
  - %% %
  - %n newline
  - %x{<tokenname>} add dynamic tokens to your log. Tokens are specified in the tokens parameter
You can use %[ and %] to define a colored block.

Date
- y year
- M month
- d day
- h hour
- m minute
- s seconds
- S milliseconds
- O timezone offet

Examples:
yyyy-MM-dd hh:mm:ss.SSS  (ISO8601)
yyyy-MM-ddThh:mm:ssO     (ISO8601 + TZ)
dd MM yyyy hh:mm:ss.SSS  (DATETIME)
###

console =
    type: "console"
    layout:
        type: "pattern"
        pattern: "[%d{yyyy-MM-dd hh:mm:ss}] %[[%p]%] %c - %m"

CONFIG =
    appenders: [
        console
    ]

log4js.configure CONFIG

module.exports.getLogger = (category, level='DEBUG') ->
    log = log4js.getLogger category
    log.setLevel level
    log
