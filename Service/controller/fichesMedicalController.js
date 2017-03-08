/**
 * Created by Massil on 01/02/2017.
 */
var router = require('express').Router();
var bodyParser = require('body-parser');

var FicheMedical = require('./../model/suiki/ficheMedical');
var Patient = require('./../model/suiki/patient');
var Exercice = require('./../model/suiki/exercice');
var Pathologie = require('./../model/suiki/pathologie');
var Symptome = require('./../model/suiki/symptome');
var Phase = require('./../model/suiki/phase');
var Personne = require('./../model/suiki/personne');

router.use(bodyParser.json());

router.post('/CreationFiche' , function (req , res) {
    var fiche = FicheMedical();
    console.log("Ajout d'une fiche" + req.body);
    inscrireFiche(fiche, req, res);
});

router.post('/fichesPatient' , function (req , res) {
    var idPatient = req.body.patient_id;

    getFichesByPatientId(idPatient,req,res);
});


var inscrireFiche = function (fiche, req, res) {
    var date = req.body.date;

    fiche.date = date;

    addPathologie(fiche, req, res);

};

var saveFiche = function (fiche, req,res) {
    return fiche
        .save( function (err, data) {
            res.send({fiche: fiche});
            res.end();
        });
};


var addPathologie = function(fiche, req, res){
    var nom_pathologie = req.body.pathologie.nom;
    var description_pathologie = req.body.pathologie.description;

    return Pathologie
        .findOne({
            nom : nom_pathologie,
            description : description_pathologie})
        .exec(function(err, pathologieData){
            fiche.pathologie = pathologieData;
            addSymptome(fiche, req, res);
        });
};

var addSymptome = function(fiche, req, res){
    var all_symptome = req.body.symptomes;
    var noms = [];
    all_symptome.forEach(function (element) {
        noms.push(element.nom);
    });
    Symptome.find({
        nom : {$in : noms}
    } , function(err , data){
        data.forEach(function (element) {
            fiche.symptome.push(element);
        });
        addPhase(fiche, req, res);
    });
};

var addPhase = function(fiche, req, res){
    var nom_phase = req.body.phase.nom;
    var description_phase = req.body.phase.description;

    return Phase
        .findOne({
            nom : nom_phase,
            description : description_phase})
        .exec(function(err, phaseData){
            fiche.phase = phaseData;
            addExercice(fiche, req, res)
        });

};

var addExercice = function(fiche, req, res){
    var all_exercices = req.body.exercices;
    var noms = [];

    all_exercices.forEach(function (element) {
        noms.push(element.nom);
    });
    Exercice.find({
        nom : {$in : noms}
    } , function(err , data){
        data.forEach(function (element) {
            fiche.exercice.push(element);
        });
        saveFiche(fiche, req, res);
        console.log(fiche);
    });
};



/**
 * Fonction permettant de retourner l'id de la phase courante du patient
 * @param phase La phase
 * @returns L'identifiant de la phase
 */

//TODO get fiches médicales d'un patient
var getFichesByPatientId = function (idPatient, req, res) {
    return Patient
        .findOne({ personne : idPatient})
        .populate("fiches")
        .exec(function(err, patientData){
            console.log("Patient data: " + patientData);
            getFiches(patientData.fiches,res);
        });
}

//fiches est un tableau ou il y a toute les fiches, ensuite on les affiches.
var getFiches = function (fiches, res) {

    return fiches.forEach(function (element) {
        FicheMedical.find({ _id : element._id}
        , function (err, data) {
                console.log("Fiche médical " + data);
                res.JSON(data);
            });
    });
};



module.exports = router;