/**
 * Created by Massil on 25/01/2017.
 */
var db = require('./../../config/db');

var Schema = db.Schema;

var utilisateur = new Schema({
    nom_utilisateur : 'String',
    mot_de_passe : 'String',
    profile : {type : Schema.Types.ObjectId , ref : 'Personne'}
});

module.exports = db.model('Utilisateur' , utilisateur);