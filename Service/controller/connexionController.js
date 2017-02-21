var router = require('express').Router();
var mongoose = require('mongoose');
var Utilisateur = require('./../model/suiki/utilisateur');
var Personne = require('./../model/suiki/patient');
var Medecin = require('./../model/suiki/medecin');
var ReponseHttp = require('./../model/http/httpReponse');

var bodyParser = require('body-parser');

router.use(bodyParser.json());

/**
 * Connexion d'un utilisateur patient
 * Renvoie true si connexion réussie et Profile de l'utilisateur
 */
router.post('/patient' , function (req , res) {
    console.log(req.body);
    var nom_utilisateur = req.body.nom_utilisateur;
    var password = req.body.mot_de_passe;

    connecter(nom_utilisateur , password, res);

});

/**
 * Connexion d'un utilisateur medecin
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
                var reponse = ReponseHttp.setReponse(true , user.profile , err);
                res.send(reponse);
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
                verificationMedecin(user.profile , res);
            });
};

/**
 * Fonction vérifiant qu'une personne est bien un médecin
 * @param personneM         La personne à vérifier
 * @param res               Le résultat de la requête
 */
var verificationMedecin = function(personneM , res)
{
    console.log(personneM.nom +" Personne dans vérification Medecin \n\n");
    Medecin
        .find({personne: personneM._id})
        //.populate('personne')
        .exec(function(err, medecin) {
            console.log(medecin);
            res.send({status : true , medecin : medecin , error : err});
        });
};

module.exports = router;