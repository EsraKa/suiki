/**
 * Created by Massil on 18/02/2017.
 */
var rooter = require('express').Router();
var bodyParser = require('body-parser');

var Patient = require('./../model/suiki/patient');
var Medecin = require('./../model/suiki/medecin');


//rooter.use(bodyParser.json());

rooter.get('/:idPatient/patient' , function (req , res) {
    var idPatient = req.params.idPatient;



});

rooter.post('/:idMedecin/medecin', function (req, res) {
    var idMedecin = req.params.idMedecin;
    var id_patient = req.body.id_patient;

    getPatient(id_patient.toString(),res);
    getMedecin(idMedecin.toString(),res);
});


var getPatient = function(patientId , res)
{
    Patient
        .findById(patientId)
        .populate("personne")
        .exec(function (err , data) {
            console.log("patient information (getPatient) : " + data);
            console.log(err);
            res.send({patient: data});
            res.end();
        });
};

// Recupère les information du medecin
var getMedecin = function (idMedecin, res) {
    Medecin
        .findById(idMedecin)
        .populate("personne")
        .exec(function (err , data) {
            console.log("medecin information (getMedecin) : " + data);
            console.log(err);
            res.send({medecin: data});
            res.end();
        });
    /* .exec(function (err , medecin) {

     });*/
};

module.exports = rooter;