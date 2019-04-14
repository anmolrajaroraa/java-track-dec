//const http = require('http');
//const fs = require('fs');
//const play = require('./play');
//const httpFile = require('./http');
//const requestHandler = require('./routes');
//const routes = require('./routes'); 
const express = require('express');
const app = express();
const bodyParser = require('body-parser');

/*app.use( (req, res, next) => {
    console.log("In the middleware");
    //res.end();
    next();
} )*/

/*app.use('/', (req, res, next) => {
    console.log('This always runs!');
    next();
})*/

app.use(bodyParser.urlencoded({extended:false}));

app.get('/add-product', (req, res, next) => {
    console.log("Add product route");
    //next();
    //res.send('<h1>The "Add Product" page</h1>');
    res.send('<form action="/product" method="POST"><input type="text" name="title"><button type="submit">Submit</button></form>');
})

app.post('/product', (req, res, next) => {
    console.log(req.body);
    res.redirect('/');
})

app.get('/add', (req, res, next) => {
    res.send('<h1>The "Add" page</h1>');
})

app.get( '/', (req, res, next) => {
    console.log('In another middleware');
    //res.write();
    //res.end();
    res.send('<h1>Hello from express!</h1>');
})

app.listen(3000);

/*function rqListener(req,res){

}*/

//http.createServer( rqListener );
/*http.createServer( function(req,res){

})*/

//const server = http.createServer( app );

//server.listen(3000);

//console.log( routes.someText );
