const tokenOperations = require('./token');
const config = require('./config');
function checkToken(request, response, next){
    let token = request.headers['auth-token'];
    if(token){
        let decoded = tokenOperations.verifyToken(token);
        console.log('After token verification', decoded);
        if(!decoded){
            response.status(401).json({status: config.status.ERROR, message: 'Invalid token'});
        }
        else{
            next();
        }
    }
    else{
        response.status(401).json({status: config.status.ERROR, message: 'You are unauthorized to access this page'});
    }
}
module.exports = checkToken;