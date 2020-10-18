'use strict';
const AWS = require('aws-sdk');
const fetch = require('node-fetch');

exports.handler = async (event, context, ) => {
    const { id, coordenadas } = JSON.parse(event.body);
    let responseBody = "";
    

    const lugares = await getLugaresCercanosMaps(coordenadas);
    const usuario = await getUsuarioPorId(id);
    const establecimientos = await getEstablecimientos(lugares);


    responseBody = JSON.stringify(establecimientos);

    
    
    
    
    return {
        statusCode: 200,
        headers: {
            "Content-Type": "application/json",
            "Access-Control-Allow-Origin": "*"
        },
        body: responseBody,
        isBase64Encoded: false
    };



};


async function getUsuarioPorId(id){
    
    
    const params = {
        TableName: "Usuario",
     Key: {
         id: id
        }
    }

    
    const documentClient = new AWS.DynamoDB.DocumentClient();
    const data = await documentClient.get(params).promise();

    return data
}



async function getEstablecimientos(lugares){

    const aaa = "";
    const listaCoordenadas =[];

    lugares.forEach(lugar => {
        listaCoordenadas.push(lugar.geometry.location);

    });
    const params = {
        TableName: "Establecimiento"
    }
        

        
    const documentClient = new AWS.DynamoDB.DocumentClient();
    const data = await documentClient.scan(params).promise();
        
     
    return data.Items[1];
       
    }
    

async function getLugaresCercanosMaps(coordenadas) {

    const url = "https://maps.googleapis.com/maps/api/place/findplacefromtext/json?" +
    "input=*&inputtype=textquery&fields=formatted_address,name,geometry,types&language=es&locationbias=circle:25@" +
    coordenadas[0] +"," + coordenadas[1]+ "&key={}";

    const params = {
        method: "GET",
        headers: {"Content-Type":"application/json"},
    };

    let lugares = await fetch(url, params);
    let json = await lugares.json();
    return json.candidates;
}


