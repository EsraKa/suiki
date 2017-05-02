/**
 * Created by Massil on 24/02/2017.
 */
//ajout historique médical pour un patient
//  req : id user - exercice

var router = require('express').Router();
var bodyParser = require('body-parser');

var Patient = require('./../model/suiki/patient');
var Historique = require('./../model/suiki/historique_exercices');
var Exercice = require('./../model/suiki/exercice');

router.use(bodyParser.json());

router.post('/CreationHistorique' , function (req , res) {
    var historique = Historique();
    console.log('Création historique : ' + req.body);
    inscrireHistorique(historique, req, res);
});

router.get('/GetHistorique' , function (req , res) {
    var idPatient = req.body.patient;
    console.log('Get historique : ' + req.body);
    getHistoriqueByPatientId(idPatient, req, res);
});

var inscrireHistorique = function (historique, req, res) {
    var note = req.body.note;
    var commentaire = req.body.commentaire;
    var date = req.body.date;
    var temps = req.body.temps;
    var maj = req.body.maj;

    historique.date = date;
    historique.note = note;
    historique.commentaire = commentaire;
    historique.temps = temps;
    historique.maj = maj;
    

    addExercice(historique, req, res);

};

var addExercice = function(historique, req, res){
    var id_exercice = req.body.exercice;

    return Exercice
        .findOne({
            _id : id_exercice})
        .exec(function(err, exerciceData){
            historique.exercice = exerciceData;
            addPatient(historique, req, res);
        });
};

var addPatient = function(historique, req, res){
    var id_patient = req.body.patient;

    return Patient
        .findOne({
            _id : id_patient})
        .exec(function(err, patientData){
            historique.patient = patientData;
            saveFiche(historique, req, res);
        });
};

var saveFiche = function (historique, req,res) {
    return Historique
        .save( function (err, data) {
            res.send({historique: historique});
            res.end();
        });
};

//récupération des historique médicales d'une patient
var getHistoriqueByPatientId = function (idPatient, req, res) {
    return Historique
        .find({ personne : idPatient})
        .exec(function(err, historiqueData){
            console.log("Historique data: " + historiqueData);
            res.send(historiqueData);
            res.end();
        });
}