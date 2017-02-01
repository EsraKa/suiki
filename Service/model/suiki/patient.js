/**
 * Created by Massil on 25/01/2017.
 */
var db = require('./../../config/db');

var Schema = db.Schema;

/**
 * Patient:
 *  - Personne : Information personnelles du patient
 *  - Fiches : Fiches médicales associées au patient
 */
var patient = Schema({
    personne : {type : Schema.Types.ObjectId , ref : 'Personne'},
    fiches : [{type : Schema.Types.ObjectId , ref : 'FicheMedical'}]
});

module.exports = db.model('Patient' , patient);