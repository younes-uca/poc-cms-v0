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


  @duplicate
  Scenario Outline: POST Order Boutique Twice with same code - expect <responseCode> as response code
    * postBody.code = uniqueId
    * def order_boutique_count = db.readValue('select count(*) FROM bf.buying_frame')

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * request postBody
    * method POST
    * status <responseCode>
    * eval if(__num==1 && order_boutique_count != db.readValue('select count(*) FROM bf.buying_frame')) karate.fail("order_boutique count values are different")

    Examples:
      | responseCode |
      | 201          |
      | 226          |


  Scenario: Fail - GetByID Not Found

    * path 'id', 99999999
    * header Authorization = 'Bearer ' + adminToken
    * method GET
    * status 404
    * match response.length == 0



  Scenario: Fail - POST Order Boutique without Body

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method POST
    * status 400
    * match response.error == "Bad Request"



  Scenario: Fail - POST Order Boutique without Authorization

    * path ''
    * method POST
    * status 401
    * match response.error == "Unauthorized"



  Scenario: Fail - Save Order with method PATCH

    * path ''
    * header Authorization = 'Bearer ' + adminToken
    * method PATCH
    * status 405
    * match response.error == "Method Not Allowed"