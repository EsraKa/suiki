7/**
 * Created by Massil on 25/01/2017.
 */
var router = require('express').Router();
var Symptome = require('./../model/suiki/symptome');

var bodyParser = require('body-parser');

router.use(bodyParser.json());

router.put('/' , function(req , res){
    var nom = req.body.nom;
    var description = req.body.description;

    var symptome = Symptome({
        nom : nom,
        description : description
    });

    symptome.save();
    res.end();
});

module.exports = router;