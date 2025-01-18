package com.example.productapi.restAssuredApiCalls;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;
import java.util.Map;
import static com.example.productapi.config.GlobalConfig.APIsGlobalConfigs.RESPONSE_MESSAGE;
import static io.restassured.config.EncoderConfig.encoderConfig;

public class RestAssuredApiCall {

    public static void setup(String baseURL)
    {

        RestAssured.baseURI = baseURL;
    }

    //The HTTP GET request is used to fetch a resource from a server.
    public static @NotNull Response getRequest(String method) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .when()
                .get(method)
                .then()
                .extract().response();
        System.out.println("Method Name:\n"+method);
        RESPONSE_MESSAGE = response.getBody().asString();
        System.out.println("HTTP Response Status Code:"+ response.statusCode());
        System.out.println("HTTP Response Body: \n"+RESPONSE_MESSAGE);

        return response;
    }

    //  send query parameters along with the GET request, we use the queryParam method.
    public static @NotNull Response getRequestWithQueryParam(String method,String paramKey,String paramValue) {
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .param(paramKey, paramValue)
                .when()
                .get(method)
                .then()
                .extract().response();
        RESPONSE_MESSAGE = response.getBody().asString();
        System.out.println("HTTP Response Status Code:"+response.statusCode());
        System.out.println("HTTP Response Body: \n"+RESPONSE_MESSAGE);
        return response;
    }

    // HTTP POST request is used to post data or create a resource on a server
    public static @NotNull Response postRequestWithBody(String method, String requestBody) {
        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(method)
                .then()
                .extract().response();
        RESPONSE_MESSAGE = response.getBody().asString();
        System.out.println("HTTP Response Status Code:"+response.statusCode());
        System.out.println("HTTP Response Body: \n"+RESPONSE_MESSAGE);

        return response;
    }

    // HTTP POST request is used to post data or create a resource on a server
    public static @NotNull Response postRequestWithQueryParam(String method, Map requestParam) {
        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .queryParams(requestParam)
                .when()
                .post(method)
                .then()
                .extract().response();
        RESPONSE_MESSAGE = response.getBody().asString();
        System.out.println("HTTP Response Status Code:"+response.statusCode());
        System.out.println("HTTP Response Body: \n"+RESPONSE_MESSAGE);

        return response;
    }

    // HTTP POST request is used to post data or create a resource on a server
    public static @NotNull Response postRequestWithFormParamAndAccessToken(String method, Map requestParam) {
        Response response = RestAssured.given()
                .config(RestAssured.config().encoderConfig(encoderConfig().encodeContentTypeAs("multipart/form-data", ContentType.TEXT)))
                .and()
                .params(requestParam)
                .when()
                .post(method)
                .then()
                .extract().response();
        RESPONSE_MESSAGE = response.getBody().asString();
        System.out.println("HTTP Response Status Code:"+response.statusCode());
        System.out.println("HTTP Response Body: \n"+RESPONSE_MESSAGE);

        return response;
    }

    public static @NotNull Response postRequestWithAccessToken(String method, String requestBody) {
        Response response = RestAssured.given()
                .and()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .post(method)
                .then()
                .extract().response();
        RESPONSE_MESSAGE = response.getBody().asString();
        System.out.println("Request Body:\n"+requestBody);
        System.out.println("HTTP Response Status Code:" + response.statusCode());
        System.out.println("HTTP Response Body: \n"+RESPONSE_MESSAGE);

        return response;
    }

    //The PUT request updates a resource but requires the full JSON payload.
    public static @NotNull Response putRequest(String method, String requestBody) {

        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .put(method)
                .then()
                .extract().response();
        RESPONSE_MESSAGE = response.getBody().asString();
        System.out.println("Request Body:\n"+requestBody);
        System.out.println("HTTP Response Status Code:"+response.statusCode());
        System.out.println("HTTP Response Body: \n"+RESPONSE_MESSAGE);

        return response;
    }

    public static @NotNull Response getRequestWithQueryMapParam(String method, Map requestParam) {
        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .queryParams(requestParam)
                .when()
                .get(method)
                .then()
                .extract().response();
        System.out.println("Method Name:\n"+method+"\n Request Param:\n"+requestParam);
        RESPONSE_MESSAGE = response.getBody().asString();
        System.out.println("HTTP Response Status Code:"+response.statusCode());
        System.out.println("HTTP Response Body: \n"+RESPONSE_MESSAGE);

        return response;
    }


    //The PATCH request updates a resource but requires only the field(s) which is being updated in the payload.
    public static @NotNull Response patchRequest(String requestBody) {
        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .and()
                .body(requestBody)
                .when()
                .patch("/posts/1")
                .then()
                .extract().response();

        System.out.println("HTTP Response Status Code:"+response.statusCode());

        return response;
    }

    //The DELETE request is used to delete a resource from a server.
    public static @NotNull Response deleteRequest(String resourceToDelete) {
        Response response = RestAssured.given()
                .header("Content-type", "application/json")
                .when()
                .delete(resourceToDelete)
                .then()
                .extract().response();

        System.out.println("HTTP Response Status Code:"+response.statusCode());

        return response;
    }
}
