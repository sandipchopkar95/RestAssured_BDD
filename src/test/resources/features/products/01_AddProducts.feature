@Product  @CreateProductsRequest
Feature: Create Product request

  @ValidCreateProductRequest @APIChaining
  Scenario Outline: <scenarioNo> <scenarioName>
    Given User calls <moduleName> with <httpMethod> method and with scenario <scenarioName>
    Then http_status_code is <httpCode>
    And response_body matches expected data for request <httpMethod> and <moduleName>
    Examples:
      | scenarioNo | moduleName | httpMethod | scenarioName                   | httpCode |
      | 01         | "product"  | "POST"     | "Valid_Create_Product_Request" | 200      |

  @InvalidCreateProductRequest
  Scenario Outline: <scenarioNo> <scenarioName>
    Given User calls <moduleName> with <httpMethod> method and with scenario <scenarioName>
    Then http_status_code is <httpCode>
    And response_body matches expected data for request <httpMethod> and <moduleName>
    Examples:
      | scenarioNo | moduleName | httpMethod | scenarioName                                 | httpCode |
      | 02         | "product"  | "POST"     | "Invalid_Create_Product_Request_Empty_Title" | 200      |

