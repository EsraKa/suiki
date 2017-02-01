/**
 * Created by Massil on 25/01/2017.
 */
7/**
 * Created by Massil on 25/01/2017.
 */
var router = require('express').Router();
var Phase = require('./../model/suiki/phase');

var bodyParser = require('body-parser');

router.use(bodyParser.json());

router.get('/' , function (req , res) {
    Phase
        .find({})
        .exec(function(data){
            res.send(data);
            res.end();
        } , function (err) {
            res.send(err);
            res.end();
        });

});

router.get('/:nom' , function (req , res) {
    Phase
        .find({
            nom : req.params.nom
        })
        .exec(function(data){
            res.send(data);
            res.end();
        },function (err) {
            res.send(err);
            res.end();
        })
});

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