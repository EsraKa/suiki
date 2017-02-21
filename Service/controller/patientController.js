/**
 * Created by Massil on 18/02/2017.
 */
var rooter = require('express').Router;
var bodyParser = require('body-parser');

var Patient = require('./../model/suiki/patient');

//rooter.use(bodyParser.json());

rooter.get('/:idPatient' , function (req , res) {
    var idPatient = req.params.idPatient;



});

var getPatient = function(patientId , res)
{
    Patient
        .find({personne : patientId})
        .exec(function(err , patient){
            res.send()
        })
}

module.exports = rooter;