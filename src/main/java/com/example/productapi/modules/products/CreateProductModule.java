package com.example.productapi.modules.products;

import com.example.productapi.config.GlobalConfig.APIsGlobalConfigs;
import com.example.productapi.config.product.CreateProductConfig;
import com.example.productapi.pojos.productPayloads.Request.ProductPayload;
import com.example.productapi.restAssuredApiCalls.RestAssuredApiCall;
import com.example.productapi.utils.jsontopojo.JsonUtils;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import static com.example.productapi.config.product.CreateProductConfig.FETCH_API_KEY_METHOD;

public class CreateProductModule {

    private static final Faker faker = new Faker();
    public static ProductPayload expectedProductPayload;
    public static void sendCreateRequestWithScenarioName(@NotNull String scenarioName) {
        switch (scenarioName) {
            case CreateProductConfig.VALID_CREATE_PRODUCT_REQUEST:
                expectedProductPayload = createNewProduct(FETCH_API_KEY_METHOD);
                break;
            case CreateProductConfig.INVALID_CREATE_PRODUCT_REQUEST_EMPTY_TITLE:
                expectedProductPayload = createNewProductWithEmptyTitle(FETCH_API_KEY_METHOD);
                break;

            default:
                throw new IllegalArgumentException("Unknown scenario name: " + scenarioName);
        }
    }

    private static ProductPayload createNewProduct(@NotNull String methodName) {
        ProductPayload productPayload = new ProductPayload();
        productPayload.setTitle(faker.name().title());
        productPayload.setPrice(faker.number().randomNumber());
        productPayload.setDescription(faker.lorem().sentence());
        productPayload.setImage(faker.internet().image());
        productPayload.setCategory(faker.commerce().department());
//        ProductPayload.Attributes attributes = new ProductPayload.Attributes();
//        attributes.setSmall("10x10");
//        productPayload.setAttributes(attributes);
        RestAssuredApiCall.setup(APIsGlobalConfigs.BASE_URL);
        Response response = RestAssuredApiCall.postRequestWithBody(methodName,
                String.valueOf(JsonUtils.objectToJsonString(productPayload)));
        APIsGlobalConfigs.HTTP_STATUS_CODE = response.getStatusCode();
        int productId = response.jsonPath().getInt("id");
        APIsGlobalConfigs.RESPONSE_PRODUCT_ID = String.valueOf(productId);
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Product Id Created : " + APIsGlobalConfigs.RESPONSE_PRODUCT_ID);

        return productPayload;
    }

    private static ProductPayload createNewProductWithEmptyTitle(@NotNull String methodName) {
        ProductPayload productPayload = new ProductPayload();
        productPayload.setPrice(faker.number().randomNumber());
        productPayload.setDescription(faker.lorem().sentence());
        productPayload.setImage(faker.internet().image());
        productPayload.setCategory(faker.commerce().department());
        RestAssuredApiCall.setup(APIsGlobalConfigs.BASE_URL);
        Response response = RestAssuredApiCall.postRequestWithBody(methodName,
                String.valueOf(JsonUtils.objectToJsonString(productPayload)));
        APIsGlobalConfigs.HTTP_STATUS_CODE = response.getStatusCode();
        System.out.println("Response Status Code: " + response.getStatusCode());
        return productPayload;
    }
}
