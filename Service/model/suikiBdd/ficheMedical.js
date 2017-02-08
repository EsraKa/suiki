/**
 * Created by Massil on 25/01/2017.
 */
var db = require('./../../config/db');

var Schema = db.Schema;

var ficheMedical = Schema({
    date : 'Date',
    pathologie : {type : Schema.Types.ObjectId , ref : 'Pathologie'},
    symptome : [{type : Schema.Types.ObjectId , ref:'Symptome'}],
    phase : {type : Schema.Types.ObjectId , ref : 'Phase'},
    exercice : [{type : Schema.Types.ObjectId , ref:'Exercice'}]
});

module.exports = db.model('FicheMedical' , ficheMedical);