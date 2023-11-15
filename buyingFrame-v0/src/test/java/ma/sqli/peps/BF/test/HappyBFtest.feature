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


  @save
  Scenario: POST Buying frame and GET it by ID
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status 201


    * path 'id', response.id
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 400
    * karate.match("each response contains FindAllSchema")


  @put
  Scenario: Update Buying frame and GET it by ID
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status 201


    * path 'id', response.id
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 200
    * karate.match("each response contains FindAllSchema")


  @delete
  Scenario: DELETE Buying frame and GET it

    # POST a BF
    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status 201
    * def bfId = response.id

    # Assert that the BF exist
    * path 'id', bfId
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 200

    # Delete the BF
    * path 'id', bfId
    * header Authorization = 'Bearer ' + adminToken
    * method DELETE
    * status 200


    # Assert that the BF not exist successfully
    * path 'id', bfId
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 404


  @FindAll
  Scenario Outline: Find All BF (204 & 200)

    * def payload = ("<method>" == "POST") ? postBody : {}
    * postBody.code = uniqueId

    * path <paths>
    * header Authorization = 'Bearer ' + adminToken
    * request payload
    * method <method>
    * status <responseCode>
    * def res = karate.match(<matching>[0])
    * match res == { pass: true, message: null }
    * def res = karate.match(<matching>[1])
    * match res == { pass: true, message: null }


    Examples:
      | responseCode | paths         | method | matching                                                                                 |
      | 204          | ''            | GET    | ["response.length == 0", "payload != ''"]                                                |
      | 201          | ''            | POST   | ["payload != ''", "payload != ''"]                                                       |
      | 200          | ''            | GET    | ["each response contains FindAllSchema "," response[0].code == postBody.code"] |


