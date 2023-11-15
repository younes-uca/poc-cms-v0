Feature: APP Test

  Background:
    * call read('karate-config.js')
    * url actuatorUri
    * header Content-Type = 'application/json'


  Scenario: Check DB, DiscSpace and Ping UP
    * path 'health'
    * method GET
    * status 200
    * match response.status == "UP"


  Scenario: Check App Info
    * path 'info'
    * method GET
    * status 200
    * match response.app.name == "peps"

