var router = require('express').Router();

router.use('/' , require('./homeController'));

module.exports = router;