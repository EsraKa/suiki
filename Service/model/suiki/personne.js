/**
 * Created by Massil on 25/01/2017.
 */
var db = require('./../../config/db');

var Schema = db.Schema;

/**
 * Personne
 *  - Nom : Nom de famille
 *  - Prenom : Prenom
 *  - Email : Adresse mail
 */
var personne = Schema({
    nom : 'String',
    prenom : 'String' ,
    email : 'String'
});

module.exports = db.model('Personne' , personne);


