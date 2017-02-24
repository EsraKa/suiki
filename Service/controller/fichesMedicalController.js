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

router.post('/' , function (req , res) {
    console.log("Ajout d'une fiche");
    inscrireFiche(req, res);
});

var inscrireFiche = function(req , res)
{
    var date = req.body.date;

    var profile = req.body.profile;

    var nom_pathologie = req.body.pathologie.nom;
    var  description_pathologie = req.body.pathologie.description;

    // pour avoir un tableau de symptome.
    var all_symptome = req.body.symptomes;

    var nom_phase = req.body.phase.nom;
    var  description_phase = req.body.phase.description;

    var all_exercice = req.body.exercices;

    var fiche = FicheMedical ();

    fiche.date = date;

    addPathologie(nom_pathologie , description_pathologie, fiche, req , res)
        .then(addSymptome(all_symptome, fiche, req, res))
        .then(addPhase(nom_phase, description_phase, fiche, req, res))
        .then(addExercice(all_exercice, fiche, req, res))
        .then(saveFiche(fiche))
        .then(addFicheToPatient(profile , fiche));
    res.send({fiche : fiche});
    res.end();

};

var saveFiche = function (fiche) {
    fiche.save();
    console.log(" \n === FINALY FICHE === \n");
};

var addPathologie = function(nom, description, fiche, req, res){
    return Pathologie
        .find({
            nom : nom,
            description : description })
        .exec(function(err, pathologieData){
            console.log("Pathologie data: " + pathologieData);
            fiche.pathologie = pathologieData;
        });
};

var addSymptome = function(all_symptome, fiche, req, res){
    getSymptomes(all_symptome, fiche);
};

var addPhase = function(nom, description, fiche, req, res){
    return Phase
        .find({
            nom : nom,
            description : description })
        .exec(function(err, phaseData){
            console.log("Phase data: " + phaseData);
            fiche.phase = phaseData;
        });
};

var addExercice = function(all_exercice, fiche, req, res){
    getExercices(all_exercice, fiche);
};



/**
 * Fonction permettant de retourner l'id de la phase courante du patient
 * @param phase La phase
 * @returns L'identifiant de la phase
 */


var getExercices = function(exercices, fiche)
{
    return exercices.forEach(function(exercice){
        Exercice
            .find({nom : exercice.nom , description:exercice.description}
            ,function(err , data){
                fiche.exercice = data;
                console.log("Exercices data : " + data);
        });
    });
};


var getSymptomes = function(symptomes, fiche)
{
    return symptomes.forEach(function (element) {
        Symptome.find({nom : element.nom}
            , function (err , data) {
                fiche.symptome = data;
                console.log("Symptomes data : " + data);
            });
    });
};

//TODO get fiches médicales d'un patient


module.exports = router;