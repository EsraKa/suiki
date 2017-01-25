/**
 * Created by Massil on 25/01/2017.
 */
7/**
 * Created by Massil on 25/01/2017.
 */
var router = require('express').Router();
var Phase = require('./../model/phase');

var bodyParser = require('body-parser');

router.use(bodyParser.json());

router.put('/' , function(req , res){
    var nom = req.body.nom;
    var description = req.body.description;
    var phase = Phase({
        nom : nom,
        description : description
    });
    phase.save();
    res.end();
});

module.exports = router;