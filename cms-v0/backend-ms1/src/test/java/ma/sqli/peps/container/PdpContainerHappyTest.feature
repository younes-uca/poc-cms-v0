Feature: PdpContainer

  Background:
    * url 'http://localhost:8036/api/admin/pdpContainer/'


  Scenario: POST Pdp container and GET it by ID
    * def postBody =
    """
    {
    "productCode": "productCode-0",
    "code": "code-0",
    "buyingFrame": "buyingFrame-0",



    "label": "label-0",
    "title": "title-0",
    "name": "name-0",

    "productType": {"id":"0"},
    "type": {"id":"0"},
    "version": {"id":"0"},


        "slots": [
            {
                    "type": {"id":"0"},
                    "pdpContainer": {"id":"0"},
            },
            {
                    "type": {"id":"0"},
                    "pdpContainer": {"id":"0"},
            }
        ]

    """
    Given path ''
    And request postBody
    When method POST
    Then status 201

    * def output = response.output

    Given path 'id', output.id
    When method GET
    Then status 200


  Scenario: DELETE Pdp container and GET all

    Given path 'reference/order-5'
    When method DELETE
    Then status 200

    * def output = response.output

    Given path ''
    When method GET
    Then status 204
    # Todo: 200 in case there is other orders, otherwise 204 if no order in DB




