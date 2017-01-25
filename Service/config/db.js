/**
 * Created by Massil on 25/01/2017.
 */
var mongoose = require('mongoose');
var dbconf = require('./dbconf');

var db = mongoose.connect(dbconf.protocol + '://' +
    dbconf.server + ':' +
    dbconf.port + '/' +
    dbconf.dbname);

module.exports = db;