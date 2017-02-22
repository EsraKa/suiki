/**
 * Created by Massil on 18/02/2017.
 */
var rooter = require('express').Router();
var bodyParser = require('body-parser');

var Patient = require('./../model/suiki/patient');
var Medecin = require('./../model/suiki/medecin');


rooter.use(bodyParser.json());

rooter.get('/:idPatient/patient' , function (req , res) {
    var idPatient = req.params.idPatient;



});

rooter.post('/:idMedecin/medecin', function (req, res) {
    console.log(req.body);
    var idMedecin = req.params.idMedecin;
    var id_patient = req.body.id_patient;

    getMedecin(idMedecin,id_patient,res);

});

// Recupère les information du medecin et associe un patient à la liste.
var getMedecin = function (idMedecin, idPatient, res) {
    Medecin
        .findById(idMedecin)
        .populate("personne")
        .populate("patient")
        .exec(function (err , medecin) {
            console.log("medecin information (getMedecin) : " + medecin);
            console.log(err);
            Patient
                .findById(idPatient)
                .populate("personne")
                .exec(function (err , patient) {

                    console.log("patient information (getPatient) : " + patient);
                    console.log(err);

                    medecin.patient.push(patient);

                    console.log("medecin final : " + medecin);

                    res.send({medecin: medecin});
                });

        });
};

module.exports = rooter;