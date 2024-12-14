package restassured.stepdefinitions;

import io.cucumber.java.en.*;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.*;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

import static org.junit.Assert.*;


public class Products {

    private int responseCode;
    private RequestSpecification httpRequest;
    private Response response;
    private ResponseBody body;
    private JSONObject requestParams;
    private JsonPath jsonPath;

    @Given("I hit the url of get product API")
    public void i_hit_the_url_of_get_product_api() {
        RestAssured.baseURI = "https://fakestoreapi.com/products";
    }

    @When("I pass the url in the request")
    public void i_pass_the_url_in_the_request() {
        httpRequest = RestAssured.given();
        response = httpRequest.get("products");
    }

    @Then("I receive the response code as <{int}>")
    public void i_receive_the_response_code_as(int statusCode) {
        responseCode = response.getStatusCode();
        assertEquals(statusCode, responseCode);
    }

    @Then("I verify that the rate of first product is {}")
    public void i_verify_that_the_rate_of_first_product(String expectedRate) {
        body = response.getBody();
        System.out.println("Response Body: " + body.asString()); // Debugging the response
        // Parse JSON path
        JsonPath jsonPath = body.jsonPath();
        String actualRate = jsonPath.getString("products[0].rating.rate"); // Update JSON path as per response
        System.out.println("Actual Rate: " + actualRate);
        // Assert rates are equal
        assertEquals(expectedRate, actualRate, "The rates do not match!");
    }

    @Given("I hit the url of post product API")
    public void i_Hit_The_Url_Of_Post_Product_API() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        httpRequest = RestAssured.given();
        requestParams = new JSONObject();
    }

    @And("I pass the request body of product title {}")
    public void i_Pass_The_Request_Body_Of_Product_Title_Product_Title(String productTitle) {
        requestParams.put("title", productTitle);
        requestParams.put("price", 100.00);
        requestParams.put("description", "Demo description");
        requestParams.put("image", "https://fakestoreapi.com/products/image");
        requestParams.put("category", "Sandip category");
        httpRequest.body(requestParams.toString());
        response = httpRequest.post("products");
        body = response.getBody();
        jsonPath = response.jsonPath();
    }

    @Then("I receive the response body as id as {}")
    public void i_Receive_The_Response_Body_As_Id_As(String expectedId) {
        String id = jsonPath.getJsonObject("id").toString();
        assertEquals("The product id is incorrect", expectedId, id);
    }

    @Given("I hit the url of PUT product API")
    public void i_Hit_The_Url_Of_PUT_Product_API() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }

    @When("I pass the url in the request with id to update {}")
    public void i_Pass_The_Url_in_the_request_with(String productNumber) {
        httpRequest = RestAssured.given();
        requestParams.put("title", "Change Title");
        requestParams.put("price", 99.00);
        requestParams.put("description", "Change description");
        requestParams.put("image", "https://fakestoreapi.com/products/image");
        requestParams.put("category", "Change category");
        httpRequest.body(requestParams.toString());
        response = httpRequest.put("products/"+ productNumber);
        body = response.getBody();
        jsonPath = response.jsonPath();
        String id = jsonPath.getJsonObject("id").toString();
       System.out.println("Response Body: " + body.asString());
       System.out.println("Response Line: " + response.getStatusLine());
    }

    @Given("I hit the url of Delete product API")
    public void i_Hit_The_Url_Of_Delete_Product_API() {
        RestAssured.baseURI = "https://fakestoreapi.com/";
        requestParams = new JSONObject();
    }

    @When("I pass the url in the request with id to delete {}")
    public void i_Pass_The_Url_in_the_request_with_id_to_delete(String productNumber) {
        httpRequest = RestAssured.given();
        response = httpRequest.delete("products/"+ productNumber);
    }

}
