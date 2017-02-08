/**
 * Created by Massil on 01/02/2017.
 */
var router = require('express').Router();
var bodyParser = require('body-parser');

var Patient = require('./../model/suiki/patient');
var FicheMedical = require('./../model/suiki/ficheMedical');

router.use(bodyParser.json());

router.post('/' , function(req , res){
    var profile = req.params.profile;
    console.log(profile);

    Patient
        .findOne({personne : profile._id})
        .populate('fiches')
        .exec(function(err , patient){
            console.log(patient);
            res.end();
        });

});

module.exports = router;