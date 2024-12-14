Feature: Delete product using Delete API

  Scenario Outline: Validate Delete API works correctly
    Given I hit the url of Delete product API
    When I pass the url in the request with id to delete <productNumber>
    Then I receive the response code as <200>
    Examples:
      | productNumber |
      | 5             |
    

