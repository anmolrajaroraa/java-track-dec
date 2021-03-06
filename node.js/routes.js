const fs = require('fs');

const requestHandler = (req,res) => {
    const url = req.url;
    const method = req.method;
     
    if(url === '/'){
        res.write('<html>');
        res.write('<head>');
        res.write('<title>Send message</title>')
        res.write('</head>');
        res.write('<body>');
        res.write('<form action="/message" method="POST">');
        res.write('<input type="text" name="message">')
        res.write('<button type="submit">Send message</button>')
        res.write('</form');
        res.write('</body>');
        res.write('</html>');
        return res.end();
    }

    if(url === '/message' && method === 'POST'){
        const body = [];

        req.on('data', chunk => {
            console.log(chunk);
            body.push(chunk);
        })

        return req.on('end', () => {
            console.log(Buffer.concat(body).toString());
            const parsedBody = Buffer.concat(body).toString();
            console.log(parsedBody.split('='));
            const message = parsedBody.split('=')[1];
            //fs.writeFileSync('message.txt', message);
            fs.writeFile('message.txt', message, err => {
                if(err != null){
                    console.log(err);
                }
                else{
                    console.log('File written successfully');
                    res.statusCode = 302;
                    res.setHeader('Location', '/');
                    return res.end();
                }
            })
            console.log('Message is', message);
            /*res.statusCode = 302;
            res.setHeader('Location', '/');
            return res.end();*/
        })

        //fs.writeFileSync('message.txt', "Test message");
        /*res.statusCode = 302;
        res.setHeader('Location', '/');
        return res.end();*/
    }

    //console.log(`Request url is ${req.url}, request method is ${req.method},& request headers are ${req.headers}`);
    //console.log('Request headers are',req.headers);
    res.setHeader('Content-Type', 'text/html');
    res.write('<html>');
    res.write('<head>');
    res.write('<title>My First Page</title>')
    res.write('</head>');
    res.write('<body>');
    res.write('<h1>Hello from Node.js server!</h1>');
    res.write('</body>');
    res.write('</html>');
    res.end();
}

//module.exports = requestHandler;
/*module.exports = {
    handler: requestHandler,
    someText: 'some hard-coded text'
}*/
//module.exports.handler = requestHandler;
//module.exports.someText = 'some hard-coded text again';
exports.handler = requestHandler;
exports.someText = 'new text';