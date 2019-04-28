const userModel = require('../models/userSchema');
const config = require('../../utils/config');
const tokenOperations = require('../../utils/token');
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
    },
    verify(userObject, response){
        userModel.findOne(userObject, (err, doc) => {
            if(err){
                response.status(500).json({status: config.status.ERROR, message: 'Some error occured'});
            }
            else{
                if(doc){
                    let token = tokenOperations.generateToken(userObject.userid);
                    response.status(200).json({token: token, status: config.status.SUCCESS, message: 'User login successful'})
                }
                else{
                    response.status(200).json({status: config.status.FAIL, message: 'Invalid userid or password'});
                }
            }
        })
    }
}
module.exports = userOperations;