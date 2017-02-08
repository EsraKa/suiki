var db = require('./../../config/db');

var Schema = db.Schema;

/**
 * Phase :
 *  - Nom : Nom de la phase
 *  - Description : Description de la phase
 */
var phase = new Schema({
    nom : 'String',
    description : 'String'
});

module.exports = db.model('Phase' , phase);