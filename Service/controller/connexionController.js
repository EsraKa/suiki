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
                res.send({status : true , data :user.profile , error : err});
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

<<<<<<< HEAD
var verificationMedecin = function(personneM , res)
=======
var verificationMedecin = function(personne)
>>>>>>> 6bd7245b85eea0a02208e364ab3fe6b4d37239bb
{
    console.log(personneM.nom +" Personne dans vérification Medecin \n\n");
    Medecin
<<<<<<< HEAD
        .find({personne: personneM._id})
        //.populate('personne')
        .exec(function(err, medecin){
            console.log(medecin);
            res.send(medecin);
=======
        .find({})
        .populate(
            {
                path: 'personne',
                match: {
                    nom: {$gte: personne.nom},
                    prenom: {$gte: personne.prenom}
                }
            })
        .exec(function(err, medecin){
            console.log(medecin.personne.nom);
            res.send({status : true  , data : medecin.profile});
>>>>>>> 6bd7245b85eea0a02208e364ab3fe6b4d37239bb
            res.end();
        });
};

/**
 * Fonction permettant la connexion à l'application pour un medecin
 * @param nom_utilisateur   Nom d'utilisateur
 * @param password          Mot de passe de l'utilisateur
 * @param res               Resultat
 */

module.exports = router;