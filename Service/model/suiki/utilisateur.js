/**
 * Created by Massil on 25/01/2017.
 */
var db = require('./../../config/db');
var Personne = require('./personne');

var Schema = db.Schema;

/**
 * Utilisateur:
 *  - Nom_Utilisateur : Nom choisi par l'utilisateur lors de l'inscription
 *  - Mot_De_Passe : Mot de passe choisi par l'utilisateur lors de l'inscription
 *  - Profile : Information personnelles de l'utilisateur
 */
var utilisateur = new Schema({
    nom_utilisateur : 'String',
    mot_de_passe : 'String',
    profile : {type : Schema.Types.ObjectId , ref : 'Personne'}
});

module.exports = db.model('Utilisateur' , utilisateur);
