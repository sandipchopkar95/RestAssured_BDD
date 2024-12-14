Feature: Update product using PUT API

  Scenario Outline: Validate PUT API works correctly
    Given I hit the url of PUT product API
    When I pass the url in the request with id to update <productNumber>
    Then I receive the response code as <200>
    Examples:
      | productNumber |
      | 5             |


