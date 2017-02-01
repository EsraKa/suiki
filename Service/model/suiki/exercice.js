var db = require('./../../config/db');

var Schema = db.Schema;
/**
 * Table Exercice:
 *  - Nom : Nom de l'exercice
 *  - Description: Description de l'exercice
 *  - Lien : Lien youtube de l'exercice
 */
var exercice = new Schema({
    nom : 'String',
    description : 'String',
    lien : 'String'
});

module.exports = db.model('Exercice' , exercice);