/**
 * Created by Massil on 24/02/2017.
 */
var db = require('./../../config/db');

var Schema = db.Schema;

/**
 * Medecin
 *  - Personne : Information personnelles du medecin
 *  - Patient : Liste des patients
 */
var historique = Schema({
    exercice : {type : Schema.Types.ObjectId , ref : 'Exercice'},
    patient : [{type : Schema.Types.ObjectId , ref : 'Patient'}],
    note : 'String',
    commentaire : 'String',
    date : 'Date'
});

module.exports = db.model('HistoriqueExercice' , historique);