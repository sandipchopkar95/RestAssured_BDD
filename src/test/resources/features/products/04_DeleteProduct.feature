@Product  @DeleteProductsRequest
Feature: Delete Product request

  @ValidDeleteProductRequest  @APIChaining
  Scenario Outline: <scenarioNo> <scenarioName>
    Given User calls <moduleName> with <httpMethod> method and with scenario <scenarioName>
    Then http_status_code is <httpCode>
    Examples:
      | scenarioNo | moduleName | httpMethod | scenarioName                               | httpCode |
      | 01         | "product"  | "DELETE"   | "Valid_Delete_Product_With_ProductId"      | 200      |

  @InvalidDeleteProductRequest
  Scenario Outline: <scenarioNo> <scenarioName>
    Given User calls <moduleName> with <httpMethod> method and with scenario <scenarioName>
    Then http_status_code is <httpCode>
    Examples:
      | scenarioNo | moduleName | httpMethod | scenarioName                               | httpCode |
      | 02         | "product"  | "DELETE"   | "Invalid_Delete_Product_Without_ProductId" | 404      |