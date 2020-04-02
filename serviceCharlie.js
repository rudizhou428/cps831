/*
AWS Lambda function for service Charlie, accessed from either a POST/GET request and decrypts the JSON body 
that was sent when calling this service. If token is valid after decryption then return JSON data
*/


exports.handler = async (event) => {

    let crypto;
    try {
    crypto = require('crypto');
    } catch (err) {
    console.log('crypto support is disabled!');
    }

    let body;
    let loadToken;
    let data;
    let id;
    let games;
    let statusCode = '200';
    const headers = {
        'Content-Type': 'application/json',
    };
    
    
    loadToken = event.token;
    var decipher = crypto.createDecipher('aes-256-cbc','d6F3Efeq')
    var dec = decipher.update(loadToken,'hex','utf8')
    dec += decipher.final('utf8');
                

    try {
        
        data = dec.split(',');
        id = data[0].split(':');
        games = data[1].split(':');
        
        switch (event.httpMethod) {
            case 'POST':
                //body =  "ID:" + JSON.parse(JSON.stringify(event.id)) + ", " + "GAMES:" +  JSON.parse(JSON.stringify(event.games))
                body =  "ID:" + id[1] + "," + "Games:" + games[1];
                break;
                
            case 'GET':
                body =  "ID:" + id[1] + "," + "Games:" + games[1];
                break;
                
            default:
                body =  "ID:" + id[1] + "," + "Games:" + games[1];

        }
    } 
    
    catch (err) {
        statusCode = '400';
        body = err.message;
    } 
    
    finally {
        body = JSON.stringify(body);
    }

    return {
        statusCode,
        body,
        headers,
    };
    
};
