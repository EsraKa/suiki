var db = require('./../config/db');

var Schema = db.Schema;

var pathologie = new Schema({
    nom : 'String',
    description : 'String'
});

module.exports = db.model('Pathologie' , pathologie);