Feature: BuyingFrame

  Background:
    * call read('karate-config.js')
    * call read('db_cleaner.js')
    * url bfUrl
    * header Content-Type = 'application/json'

    * def postBody = read('../data/Save.json')
    * def uuid = function() { return '' + java.util.UUID.randomUUID(); }
    * postBody.reference = uuid()


  Scenario: POST Buying frame and GET it by ID
    * def postBody =
    """
    {
    "libelle": "libelle-2",
    "code": "code-2"
    }
    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Buying frame and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




