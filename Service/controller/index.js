var router = require('express').Router();

router.use('/' , require('./homeController'));
router.use('/inscription' , require('./inscriptionController'));
router.use('/connexion' , require('./connexionController'));
router.use('/pathologie' , require('./pathologieController'));
router.use('/phase' , require('./phaseController'));
router.use('/symptome' , require('./symptomeController'));

module.exports = router;