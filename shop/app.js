const express = require('express');
const app = express();
const bodyParser = require('body-parser');

app.use(express.static('public'));

app.use(bodyParser.urlencoded({extended: false}));

app.use(bodyParser.json());

app.use('/', require('./api/userApi'));

app.listen(process.env.PORT || 3000, () => {
    console.log("Server is up");
} );