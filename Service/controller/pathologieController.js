/**
 * Created by Massil on 25/01/2017.
 */

var router = require('express').Router();
var Pathologie = require('./../model/pathologie');

var bodyParser = require('body-parser');

router.use(bodyParser.json());

router.put('/' , function(req , res){
    var nom = req.body.nom;
    var description = req.body.description;
    var pathologie = Pathologie({
        nom : nom,
        description : description
    });
    pathologie.save();
    res.end();
});

module.exports = router;