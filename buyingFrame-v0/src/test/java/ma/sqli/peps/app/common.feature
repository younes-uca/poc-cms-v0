@ignore
Feature: common variables

  Background:
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * def DbUtils = Java.type('ma.sqli.peps.karate.util.DbUtils')

  Scenario: Setting adminToken as Global variables
    * def uniqueId = uuid()
    * def db = new DbUtils(datasource)

    * url rootUrl + 'login'
    * request adminCredentials
    * method POST
    * status 200
    * match response.tokenType == "Bearer"
    * match response.roles contains 'ROLE_ADMIN'
    * def adminToken = response.accessToken
