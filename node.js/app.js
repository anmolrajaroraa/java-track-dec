const http = require('http');
//const fs = require('fs');
//const play = require('./play');
//const httpFile = require('./http');
//const requestHandler = require('./routes');
//const routes = require('./routes'); 
const express = require('express')

/*function rqListener(req,res){

}*/

//http.createServer( rqListener );
/*http.createServer( function(req,res){

})*/

const server = http.createServer( routes.handler );

server.listen(3000);

//console.log( routes.someText );
