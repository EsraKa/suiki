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
    console.log(idMedecin);
    getMedecin(idMedecin.toString(),res);
});


var getPatient = function(patientId , res)
{
    Patient
        .find({personne : patientId})
        .exec(function(err , patient){
            res.send();
        })
};

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