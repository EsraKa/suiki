/**
 * Created by Massil on 25/01/2017.
 */
var db = require('./../config/db');

var Schema = db.Schema;

var utilisateur = new Schema({
    nom_utilisateur : 'String',
    mot_de_passe : 'String'
});

module.exports = db.model('Utilisateur' , utilisateur);