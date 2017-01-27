var db = require('./../../config/db');

var Schema = db.Schema;

var phase = new Schema({
    nom : 'String',
    description : 'String'
});

module.exports = db.model('Phase' , phase);