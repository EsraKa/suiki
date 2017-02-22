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

router.post("/" , function(req , res){
    var profile = req.body.profile;
    /*var fiche = req.body.fiche;
    var exercices = req.body.exercices;
    var pathologie = req.body.pathologie;
    var symptomes = req.body.symptomes;
    var phase = req.body.phase;*/

    getPatient(profile);
    res.end();

});

router.put('/' , function (req , res) {
    inscrireFiche(req, res);
})

/**
 * Fonction permettant de retourner l'id de la phase courante du patient
 * @param phase La phase
 * @returns L'identifiant de la phase
 */
var getPhaseId = function(phase)
{
    var id = null;
    Phase
        .findOne({nom : phase.nom , description : phase.description} , function (err , phase) {
            id = phase._id;
        });
    return id;
};

var getExercicesId = function(exercices)
{
    var exercicesId = [];
    exercices.forEach(function(exercice){
        Exercice
            .find({nom : exercice.nom , description:exercice.description}
            ,function(err , data){
                exercicesId.push(data._id);
                });
    });
    return exercicesId;
};

var getPathologieId = function(pathologie){
    var pathologieId = null;
    Pathologie
        .find({nom : pathologie.nom})
        .exec(function(err , data){
            pathologieId = data._id;
        });
    return pathologieId;
};

var getSymptomes = function(symptomes)
{
    var symptomesId = [];
    symptomes.forEach(function (element) {
        Symptome.find({nom : element.nom}
            , function (err , data) {
                symptomesId.push(data._id);
            });
    });
    return symptomesId;
};

var createFicheMedical = function(profile)
{

}

var getPatient = function(profile)
{
    var patientF = null;
    Personne.
        findOne({
            nom : profile.nom,
            prenom : profile.prenom,
            email : profile.email
        })
        .exec(function (err , personne) {
            console.log(personne);
            Patient
                .findOne({
                    personne : personne._id
                })
                .populate('personne')
                .exec(function (err , patient) {
                    console.log(patient);
                    patientF = patient;
                });
        });
    return patientF;
};

var ajouterFicherMedical = function(profile , pathologie , symptome , phase , exercice)
{
    var profile ;
}




module.exports = router;