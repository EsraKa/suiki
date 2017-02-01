7/**
 * Created by Massil on 25/01/2017.
 */
var router = require('express').Router();
var mongoose = require('mongoose');
var Utilisateur = require('./../model/suiki/utilisateur');
var Personne = require('./../model/suiki/patient');

var bodyParser = require('body-parser');

router.use(bodyParser.json());

/**
 * Connexion d'un utilisateur
 * Renvoie true si connexion réussie et Profile de l'utilisateur
 */
router.post('/' , function (req , res) {
    console.log(req.body);
    var nom_utilisateur = req.body.nom_utilisateur;
    var password = req.body.mot_de_passe;

    connecter(nom_utilisateur , password, res);

});

/**
 * Fonction permettant la connexion à l'application
 * @param nom_utilisateur   Nom d'utilisateur
 * @param password          Mot de passe de l'utilisateur
 * @param res               Resultat
 */
var connecter = function(nom_utilisateur , password , res)
{
    Utilisateur
        .findOne({nom_utilisateur : nom_utilisateur , mot_de_passe: password})
        .populate('profile')
        .exec(function(err , user) {
                res.send(user.profile);
                res.end();
            });
};

module.exports = router;