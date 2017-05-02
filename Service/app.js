var express =require('express');

//Initilisation d'express.
var app = express();

//On récupère les controllers du dossier controller.
app.use('/',require("./controller"));

//Server sur écoute, port 4500.
app.listen(80, function(){
	console.log("Server is up");
});