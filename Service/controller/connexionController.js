var router = require('express').Router();
var mongoose = require('mongoose');
var Utilisateur = require('./../model/suiki/utilisateur');
var Personne = require('./../model/suiki/patient');
var Medecin = require('./../model/suiki/medecin');

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
 * Connexion d'un medecin
 * Renvoie true si connexion réussie et liste des patients
 */
router.post('/medecin' , function (req , res) {
    console.log(req.body);
    var nom_utilisateur = req.body.nom_utilisateur;
    var password = req.body.mot_de_passe;

    connecterMedecin(nom_utilisateur , password, res);
});

/**
 * Fonction permettant la connexion à l'application pour un utilisateur
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
                res.write("Hello world / connexion !");
                res.end();
            });
};


/**
 * Fonction permettant la connexion à l'application pour un medecin
 * @param nom_utilisateur   Nom d'utilisateur
 * @param password          Mot de passe de l'utilisateur
 * @param res               Resultat
 */
var connecterMedecin = function(nom_utilisateur , password , res)
{
    Utilisateur
        .findOne({nom_utilisateur : nom_utilisateur , mot_de_passe: password})
        .populate('profile')
        .exec(function(err , user) {
                verificationMedecin(user.profile);
                res.end();
            });
};

var verificationMedecin = function(personne)
{
    Medecin
        .find({})
        .populate({personne : {nom : personne.nom, prenom : personne.prenom}})
        .exec(function(err, user){
            res.send(user.profile);
            res.end();
        });
}

/**
 * Fonction permettant la connexion à l'application pour un medecin
 * @param nom_utilisateur   Nom d'utilisateur
 * @param password          Mot de passe de l'utilisateur
 * @param res               Resultat
 */

module.exports = router;