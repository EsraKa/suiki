/**
 * Created by Massil on 25/01/2017.
 */
var db = require('./../../config/db');

var Schema = db.Schema;

var symptome = Schema({
    nom : 'String',
    description : 'String'
});

module.exports = db.model('Symptome' , symptome);