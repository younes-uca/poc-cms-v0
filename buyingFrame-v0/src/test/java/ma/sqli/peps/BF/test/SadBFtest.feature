Feature: BuyingFrame

  Background:
    * call read('karate-config.js')
    * call read('db_cleaner.js')
    * url bfUrl
    * header Content-Type = 'application/json'

    * def postBody = read('../data/SaveBF.json')
    * def FindAllSchema = read('../schema/FindAll.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.code = uuid()


  Scenario: POST Buying frame and GET it by ID
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status 201

    * def output = response.output

    * path 'id', output.id
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 200


  Scenario: DELETE Buying frame and GET all

    * path 'reference/order-5'
    * header Authorization = 'Bearer ' + adminToken
    * method DELETE
    * status 200

    * def output = response.output

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




