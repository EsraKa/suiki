var db = require('./../../config/db');

var Schema = db.Schema;

var exercice = new Schema({
    nom : 'String',
    description : 'String',
    lien : 'String'
});

module.exports = db.model('Exercice' , exercice);