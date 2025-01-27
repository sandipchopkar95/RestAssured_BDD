@Product  @GetProductsRequest
Feature: Get Product request

  @ValidProductRequest
  Scenario Outline:  <scenarioNo> <scenarioName>
    Given User calls <moduleName> with <httpMethod> method and with scenario <scenarioName>
    Then http_status_code is <httpCode>
    Examples:
      | scenarioNo | moduleName | httpMethod | scenarioName                | httpCode |
      | 01         | "product"  | "GET"      | "Valid_Get_Product_Request" | 200      |


  @InValidProductRequest
  Scenario Outline:  <scenarioNo> <scenarioName>
    Given User calls <moduleName> with <httpMethod> method and with scenario <scenarioName>
    Then http_status_code is <httpCode>
    Examples:
      | scenarioNo | moduleName | httpMethod | scenarioName                  | httpCode |
      | 02         | "product"  | "GET"      | "Invalid_Get_Product_Request" | 404      |

  @ValidSingleProductRequest @APIChaining
  Scenario Outline:  <scenarioNo> <scenarioName>
    Given User calls <moduleName> with <httpMethod> method and with scenario <scenarioName>
    Then http_status_code is <httpCode>
    Examples:
      | scenarioNo | moduleName | httpMethod | scenarioName               | httpCode |
      | 03         | "product"  | "GET"      | "Valid_Get_Single_Product" | 200      |

