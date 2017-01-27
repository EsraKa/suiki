var router = require('express').Router();

/**
 * Route initiale
 * Affiche 'Hello world !"
 */
router.get('/' ,function(req, res){
	res.end("Hello world !");
});

module.exports = router;