package product.cucumber.stepdefinitions;

import static com.example.productapi.config.GlobalConfig.APIsGlobalConfigs.*;

import com.example.productapi.apirouting.BaseRouteRestCall;
import com.example.productapi.modules.products.CreateProductModule;
import com.example.productapi.modules.products.FetchProductModule;
import com.example.productapi.modules.products.UpdateProductModule;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ApiStepDefinition {
    String featureModuleName;
    String featureScenarioName;

    @Given("User calls {string} with {string} method and with scenario {string}")
    public void user_calls_with_method_and_with_scenario(String moduleName, @NotNull String httpMethod, String scenarioName) {

        //Reset the assignment before execution of each testcase
        HTTP_STATUS_CODE = -200;
        RESPONSE_BODY_STATUS_CODE = -1;
        this.featureModuleName = moduleName;
        this.featureScenarioName = scenarioName;

        System.out.println("Module Name: " + moduleName + "\nHTTP Method: " + httpMethod + "\nScenario Name: " + scenarioName);

        switch (httpMethod) {

            case "POST":
                BaseRouteRestCall.routePOSTCallWithModuleAndScenarioName(moduleName, scenarioName);
                break;

            case "GET":
                BaseRouteRestCall.routeGETRequestWithModuleAndScenarioName(moduleName, scenarioName);
                break;

            case "PUT":
                BaseRouteRestCall.routePUTRequestWithModuleAndScenarioName(moduleName, scenarioName);
                break;

            case "PATCH":
                break;

            case "DELETE":
                BaseRouteRestCall.routeDELETERequestWithModuleAndScenarioName(moduleName, scenarioName);
                break;

            default:
                System.out.println("Unknown HTTP Method Name...");
        }

    }

    @Then("http_status_code is {int}")
    public void http_status_codeIsHttpCode(int httpCode) {
        assertEquals(httpCode, HTTP_STATUS_CODE);
    }

    @And("response_body_status_code is {int}")
    public void response_body_status_codeIsResponseBodyCode(int responseBodyCode) {
        assertEquals(responseBodyCode, RESPONSE_BODY_STATUS_CODE);
    }

    @And("response_body matches expected data for request {string}")
    public void response_body_matches_expected_data(String httpMethod) {
        try {
            // Ensure the RESPONSE_MESSAGE is not null
            if (RESPONSE_MESSAGE == null) {
                throw new RuntimeException("RESPONSE_MESSAGE is null. Cannot validate response body.");
            }
            // Parse the response body JSON
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonResponse = objectMapper.readTree(RESPONSE_MESSAGE);
            // Initialize the expected data map
            Map<String, Object> expectedData;
            switch (httpMethod.toUpperCase()) {
                case "POST":
                    expectedData = objectMapper.convertValue(CreateProductModule.expectedProductPayload, Map.class);
                    break;
                case "GET":
                case "PUT":
                    expectedData = objectMapper.convertValue(UpdateProductModule.expectedProductPayload, Map.class);
                    break;
                case "PATCH":
                case "DELETE":
                default:
                    throw new IllegalArgumentException("Unsupported HTTP Method: " + httpMethod);
            }

            // Validate the JSON response against the expected data
            assert expectedData != null : "Expected data is null.";
            validateJsonResponse(jsonResponse, expectedData);

            System.out.println("Response body matches the expected data for HTTP method: " + httpMethod);
        } catch (Exception e) {
            throw new RuntimeException("Error validating response body for HTTP method ["
                    + httpMethod + "]: " + e.getMessage(), e);
        }
    }

    private void validateJsonResponse(JsonNode jsonResponse, Map<String, Object> expectedValues) {
        for (Map.Entry<String, Object> entry : expectedValues.entrySet()) {
            String key = entry.getKey();
            Object expectedValue = entry.getValue();
            assertTrue(jsonResponse.has(key), "Key '" + key + "' is missing in the response.");
            JsonNode actualValueNode = jsonResponse.get(key);
            if (expectedValue instanceof Map) {
                // If the expected value is a nested structure, recurse into it
                assertTrue(actualValueNode.isObject(), "Key '" + key + "' should contain a JSON object.");
                validateJsonResponse(actualValueNode, (Map<String, Object>) expectedValue);
            } else {
                // For primitive values, compare directly
                String actualValue = actualValueNode.asText();
                assertEquals(String.valueOf(expectedValue), actualValue,
                        "Mismatch for key '" + key + "': expected = " + expectedValue + ", actual = " + actualValue);
            }
        }
    }

}



