var router = require('express').Router();

router.get('/' ,function(req, res){
	res.end("Hello world !");
});

module.exports = router;