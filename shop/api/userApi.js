const express = require('express');
const router = express.Router();
const userOperations = require('../db/helpers/userOperations');
router.post('/register', (request, response) => {
    let userid = request.body.userid;
    let password = request.body.password;
    let userObject = {
        userid: userid,
        password: password
    }
    userOperations.add(userObject, response);
})
module.exports = router;