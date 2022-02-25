# jpms-rest-server-example

[![Maven Build](https://github.com/madduci/jpms-rest-server-example/actions/workflows/build.yml/badge.svg?branch=main)](https://github.com/madduci/jpms-rest-server-example/actions/workflows/build.yml)

A repository showing how to achieve a modular design with Java.

It requires a JDK 11+ and possibly a recent maven version (3.8.x).

## Project Structure

There are 2 "core modules" defining the application interface and implementation logic and 2 alternative realisation of a REST server:

* api: defines the external API of our logic
* lib: implements the logic for the API (it's a **dummy** implementation, not a fully one!)
* jetty-rest-server: a Jetty / RESTEasy server exposing our API
* quarkus-server: a Quarkus / RESTEasy server exposing our API

## How to run the project

Open a new terminal and type the following commands:

```sh
mvn -e clean install
```

### Run Jetty

```sh
java -jar jetty-rest-server/target/jetty-rest-server-1.0.0-SNAPSHOT.jar
```

The server will bind on port 8080.

### Run Quarkus

```sh
java -jar quarkus-server/target/quarkus-app/quarkus-run.jar 
```

The server will bind on port 8080. Opening the browsers at https://localhost:8080/swagger-ui , it's possible to use the Swagger UI to test the API.

### Test the server(s):

Using cURL, you can run this command to test the API:

```sh
curl -X 'POST' \
  'http://localhost:8080/keystore/create' \
  -H 'accept: application/json' \
  -H 'Content-Type: application/json' \
  -d '{
  "type": "PKCS12",
  "algorithm": "EC",
  "alias": "string",
  "keyLength": 256,
  "keyPassword": "string",
  "password": "string"
}'
```

