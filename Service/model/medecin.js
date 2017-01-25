/**
 * Created by Massil on 25/01/2017.
 */
/**
 * Created by Massil on 25/01/2017.
 */
var db = require('./../config/db');

var Schema = db.Schema;

var patient = Schema({
    personne : {type : Schema.Types.ObjectId , ref : 'Personne'},
    patient : {type : Schema.Types.ObjectId , ref : 'Patient'}
});

module.exports = db.model('Medecin' , patient);