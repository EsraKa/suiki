/**
 * Created by Massil on 18/02/2017.
 */
var rooter = require('express').Router();
var bodyParser = require('body-parser');

var Patient = require('./../model/suiki/patient');
var Medecin = require('./../model/suiki/medecin');
var FicheMedical = require('./../model/suiki/ficheMedical');


rooter.use(bodyParser.json());

rooter.post('/:idPatient/patient/fiche' , function (req , res) {
    var idPatient = req.params.idPatient;
    var idMedecalFicheFiche = req.body.id_fiche;

    AddFicheMedicalToPatient(idPatient, idMedecalFicheFiche, res);
});

rooter.post('/:idMedecin/medecin/liste', function (req, res) {
    console.log(req.body);
    var idMedecin = req.params.idMedecin;
    var id_patient = req.body.id_patient;
    var dateFiche = req.body.date;

    AddPatientToListMedecin(idMedecin,id_patient,res);


});


var getMedecin = function(idMedecin , res)
{
    Patient
        .findById(patientId)
        .populate("personne")
        .exec(function (err , data) {
            console.log("medecin information (getMedecin) : " + data);
            console.log(err);
            return {patient: data};
        });
};

// Recupère les information du medecin et associe un patient à la liste.
var AddPatientToListMedecin = function (idMedecin, idPatient, res) {
    Medecin
        .findById(idMedecin)
        .populate("personne")
        .populate("patient")
        .exec(function (err , medecin) {
            //console.log("medecin information (AddPatientToListMedecin) : " + medecin);
            console.log(err);
            Patient
                .findById(idPatient)
                .populate("personne")
                .exec(function (err , patient) {

                    //console.log("patient information (getPatient) : " + patient);
                    console.log(err);

                    medecin.patient.push(patient);

                    console.log("medecin final : " + medecin);

                    res.send({medecin: medecin});
                });

        });
};

// Recupère un patient et on lui associe une fiche médical.
var AddFicheMedicalToPatient = function (idPatient, idMedicalFiche, res) {
    Patient
        .findById(idPatient)
        .populate("personne")
        .populate("fiches")
        .exec(function (err, patient) {
            console.log(err);
            FicheMedical
                .findById(idMedicalFiche)
                .populate("pathologie")
                .populate("symptome")
                .populate("phase")
                .populate("exercice")
                .exec(function (err, fiche) {
                    console.log("Fiche Medical : " + fiche);
                    console.log(err);

                    patient.fiches.push(fiche);
                    console.log("Patient final /w fiche : " + patient);
                    res.send({patient: patient});
                });

        });
};

module.exports = rooter;