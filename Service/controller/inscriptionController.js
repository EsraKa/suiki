7/**
 * Created by Massil on 25/01/2017.
 */
var router = require('express').Router();
var Utilisateur = require('./../model/utilisateur');
var Personne = require('./../model/personne');

var bodyParser = require('body-parser');

router.use(bodyParser.json());

router.post('/' , function (req , res) {
    console.log(req.body);
    var nom_utilisateur = req.body.nom_utilisateur;
    var password = req.body.mot_de_passe;

    Utilisateur
        .find({nom_utilisateur : nom_utilisateur , mot_de_passe: password})
        .exec(function(err , data){
            res.send(JSON.stringify({response : true}));
            res.end();
        });
});

module.exports = router;