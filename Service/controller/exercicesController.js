/**
 * Created by Massil on 01/02/2017.
 */
var router = require('express').Router();
var bodyParser = require('body-parser');
var arraySort = require('array-sort');

var Patient = require('./../model/suiki/patient');
var FicheMedical = require('./../model/suiki/ficheMedical');

router.use(bodyParser.json());

router.post('/' , function(req , res){
    var profile = req.params.profile;
    console.log(profile);

    getPatient(profile._id);

});

var getPatient = function(profileId , res)
{
    Patient
        .findOne({personne : profile._id})
        .populate('fiches')
        .exec(function(err , patient){
            //arraySort(patient.fiches , patient.fiches.date);
            //var reponse = ReponseHttp.setReponse(true , patient , err);
            console.log(patient);
            res.end();
        });
};

//TODO get exercices d'un patient

module.exports = router;