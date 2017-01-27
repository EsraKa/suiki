7/**
 * Created by Massil on 25/01/2017.
 */
var router = require('express').Router();
var Utilisateur = require('./../model/suikiBdd/utilisateur');
var Personne = require('./../model/suikiBdd/patient');

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

var connecter = function(nom_utilisateur , password , res)
{
    Utilisateur
        .findOne({nom_utilisateur : nom_utilisateur , mot_de_passe: password})
        .exec(function(err , user){
            Personne
                .find({_id : user.profile})
                .exec(function(personne){
                    console.log("Personne: " + personne);
                    res.send(JSON.stringify({status : true , data : personne}));
                    res.end();
                } , function(err){
                    res.send(JSON.stringify({status : false , data : err}));
                    res.end();
                });
        });
};

module.exports = router;