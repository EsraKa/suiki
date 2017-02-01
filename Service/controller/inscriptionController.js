7/**
 * Created by Massil on 25/01/2017.
 */
var router = require('express').Router();
var Utilisateur = require('./../model/suiki/utilisateur');
var Personne = require('./../model/suiki/personne');
var Patient = require('./../model/suiki/patient');
var Medecin = require('./../model/suiki/medecin');

var bodyParser = require('body-parser');

router.use(bodyParser.json());

router.put('/' , function (req , res) {
    inscrire(req , res);
});

/**
 * Methode permettant l'inscription d'une personne
 * Cette méthode appelle savePersonne
 * @param req   La requete
 * @param res   Le resultat
 */
var inscrire = function(req , res)
{
    var nom = req.body.profile.nom;
    var prenom = req.body.profile.prenom;
    var email = req.body.profile.email;
    var estPatient = req.body.profile.estPatient;

    savePersonne(nom , prenom , email , estPatient , req , res)
};

/**
 * Methode permettant d'ajouter une personne
 * Cette méthode, si estPatient = true, ajoute la personne en tant que patient (savePatient)
 * Sinon ajoute la personne en tant que medecin (saveMedecin)
 * @param nom           Nom de la personne
 * @param prenom        Prenom de la personne
 * @param email         Email de la personne
 * @param estPatient    Si patient = true sinon false
 * @param req           La requete
 * @param res           Le resultat
 */
var savePersonne = function(nom , prenom , email , estPatient , req , res){
    var personne = Personne({
        nom : nom,
        prenom : prenom,
        email : email
    });
    personne
        .save(function(personneData){
            console.log("Personne data: " + personneData);
            saveMedecinPatient(req.body.estPatient , personne._id , req , res);
        } , function (err) {
            console.log(err);
        });
};

/**
 * Methode permettant d'enregistrer la personne en tant que medecin ou patient
 * @param estPatient    Si true, enregistre en patient, sinon
 * @param idPersonne    Identifiant de la personne qui sera patient ou medecin
 * @param req           La requete
 * @param res           Le resultat
 */
var saveMedecinPatient = function(estPatient , idPersonne , req , res){
    if(estPatient)
    {
        savePatient(idPersonne , req , res);
    }
    else
    {
        saveMedecin(idPersonne , req , res);
    }
};

/**
 * Fonction permettant d'enregistrer une Personne en Medecin
 * @param idPersonne    Identifiant de la personne à ajouter
 * @param req           La requete
 * @param res           Le resultat
 */
var saveMedecin = function(idPersonne , req , res)
{
    var medecin = Medecin({
        personne : idPersonne
    });
    medecin.save(function(medecinData){
        saveUtilisateur(req.body.nom_utilisateur , req.body.mot_de_passe , idPersonne , res);
    } , function(err){

    });
};

/**
 * Fonction permettant d'enregistrer une Personne en Patient
 * @param idPersonne    Identifiant de la personne à ajouter
 * @param req           La requete
 * @param res           Le resultat
 */
var savePatient = function(idPersonne , req , res)
{
    var patient = Patient({
        personne : idPersonne
    });
    patient
        .save(function(patientData){
            saveUtilisateur(req.body.nom_utilisateur , req.body.mot_de_passe , idPersonne , res);
        } , function(err){

        });
};

/**
 * Fonction permettant la sauvegarde d'un utilisateur
 * @param nom_utilisateur   Pseudo utilisé par l'utilisateur
 * @param password          Mot de passe de l'utilisateur
 * @param personneId        L'indentifiant dans la table Personne
 * @param res               Le resultat
 */
var saveUtilisateur = function(nom_utilisateur , password , personneId , res)
{
    var utilisateur = Utilisateur({
        nom_utilisateur : nom_utilisateur,
        mot_de_passe : password,
        profile : personneId
    });
    utilisateur
        .save(
            function(data){
                res.send(JSON.stringify({status : true , data: utilisateur.profile}));
                res.end();
            },function (err) {
                res.send(JSON.stringify({status : false , data : err}));
                res.end();
            });
};

module.exports = router;