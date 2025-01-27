@Product  @UpdateProductsRequest
Feature: Update Product request

  @ValidUpdateProductRequest @APIChaining
  Scenario Outline: <scenarioNo> <scenarioName>
    Given User calls <moduleName> with <httpMethod> method and with scenario <scenarioName>
    Then http_status_code is <httpCode>
    And response_body matches expected data for request <httpMethod> and <moduleName>
    Examples:
      | scenarioNo | moduleName | httpMethod | scenarioName                               | httpCode |
      | 01         | "product"  | "PUT"      | "Valid_Update_Product_Title_Request"       | 200      |

  @ValidUpdateProductRequest
  Scenario Outline: <scenarioNo> <scenarioName>
    Given User calls <moduleName> with <httpMethod> method and with scenario <scenarioName>
    Then http_status_code is <httpCode>
    And response_body matches expected data for request <httpMethod> and <moduleName>
    Examples:
      | scenarioNo | moduleName | httpMethod | scenarioName                               | httpCode |
      | 02         | "product"  | "PUT"      | "Valid_Update_Product_Title_Request"       | 200      |


