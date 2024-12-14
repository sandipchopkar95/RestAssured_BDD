Feature: Get all products from the API

  Scenario: Verify the get API for the product
    Given I hit the url of get product API
    When I pass the url in the request
    Then I receive the response code as <200>

  Scenario Outline: Verify the ate of first product is correct
    Given I hit the url of get product API
    When I pass the url in the request
    Then I verify that the rate of first product is <FirstProductRate>
   Examples:
      |FirstProductRate|
      | 3.9|
