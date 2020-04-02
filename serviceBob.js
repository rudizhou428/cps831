/*
AWS Lambda function for service Bob, accessed from either a POST/GET request and creates a token for authentication access and puts the token into JSON data format
then encrypts JSON body and returns it back to service that called it.
*/


exports.handler = async (event) => {

    let crypto;
    try {
    crypto = require('crypto');
    } catch (err) {
    console.log('crypto support is disabled!');
    }

    let body;
    let statusCode = '200';
    const headers = {
        'Content-Type': 'application/json',
    };

    try {
        switch (event.httpMethod) {
            case 'POST':
                //body =  "ID:" + JSON.parse(JSON.stringify(event.id)) + ", " + "GAMES:" +  JSON.parse(JSON.stringify(event.games))
                body =  "ID:" + event.id + "," + "Games:" + event.games;
                break;
                
            case 'GET':
                body =  "ID:" + event.id + "," + "Games:" + event.games;
                break;
                
            default:
                body =  "ID:" + event.id + "," + "Games:" + event.games;

        }
    } 
    
    catch (err) {
        statusCode = '400';
        body = err.message;
    } 
    
    finally {
        body = JSON.stringify(body);
        var cipher = crypto.createCipher('aes-256-cbc','d6F3Efeq')
        var crypted = cipher.update(body,'utf8','hex')
        crypted += cipher.final('hex');
        body = crypted;
    }

    return {
        statusCode,
        body,
        headers,
    };
    
};
