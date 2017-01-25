7/**
 * Created by Massil on 25/01/2017.
 */
var router = require('express').Router();
var Utilisateur = require('./../model/utilisateur');
var Personne = require('./../model/personne');
var Patient = require('./../model/patient');
var Medecin = require('./../model/medecin');

var bodyParser = require('body-parser');

router.use(bodyParser.json());

router.put('/' , function (req , res) {
    var nom_utilisateur = req.body.nom_utilisateur;
    var password = req.body.mot_de_passe;

    var nom = req.body.nom;
    var prenom = req.body.prenom;
    var email = req.body.email;
    var estPatient = req.body.estPatient;

    var personne = Personne({
        nom : nom,
        prenom : prenom,
        email : email
    });

    personne.save();

    if(estPatient)
    {
        var patient = Patient({
            personne : personne._id
        });
        patient.save();
    }
    else
    {
        var medecin = Medecin({
            personne : personne._id
        });
        medecin.save();
    }

    var utilisateur = Utilisateur({
        nom_utilisateur : nom_utilisateur,
        mot_de_passe : password,
        profile : personne._id
    });

    utilisateur.save();

    res.end();
});

module.exports = router;