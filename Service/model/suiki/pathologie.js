var db = require('./../../config/db');

var Schema = db.Schema;

/**
 * Pathologie:
 *  - Nom : Nom de la pathologie
 *  - Description : Description de la pathologie
 */
var pathologie = new Schema({
    nom : 'String',
    description : 'String'
});

module.exports = db.model('Pathologie' , pathologie);