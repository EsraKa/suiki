var router = require('express').Router();

router.use('/' , require('./homeController'));
router.use('/inscription' , require('./inscriptionController'));

module.exports = router;