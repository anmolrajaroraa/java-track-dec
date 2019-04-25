const userModel = require('../models/userSchema');
const config = require('../../utils/config');
const userOperations = {
    add(userObject, response){
        userModel.create(userObject, err => {
            if(err){
                console.log(err);
                response.status(500).json({status: config.status.ERROR, message: 'Error in user creation'})
            }
            else{
                response.status(200).json({status: config.status.SUCCESS, message: 'User registered successfully'})
            }
        })
    }
}
module.exports = userOperations;