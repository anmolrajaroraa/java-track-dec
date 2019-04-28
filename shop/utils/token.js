const jwt = require('jsonwebtoken');
const config = require('./config');
const tokenOperations = {
    generateToken(userid){
        let token = jwt.sign({userid}, config.SECRET, {expiresIn: '1h'});
        return token;
    },
    verifyToken(token){
        let decoded = jwt.verify(token, config.SECRET);
        return decoded;
    }
}
module.exports = tokenOperations;

// const localToken = tokenOperations.generateToken('jenny');
// console.log('Token is', localToken);
// let decodedObject = tokenOperations.verifyToken(localToken);
// console.log('Decoded object is', decodedObject); 