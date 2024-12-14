Feature: Insert product using POST API

  Scenario Outline: Validate POST API works correctly
    Given I hit the url of post product API
    When I pass the url in the request
    And I pass the request body of product title <ProductTitle>
    Then I receive the response code as <200>
    Examples:
      | ProductTitle |
      | Shoes        |

  Scenario Outline: Validate POST product API response body works correctly
    Given I hit the url of post product API
    When I pass the url in the request
    And I pass the request body of product title <ProductTitle>
    Then I receive the response body as id as <Id>
    Examples:
      | ProductTitle | Id |
      | Shoes        | 21 |

