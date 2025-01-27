package com.example.productapi.modules.products;

import com.example.productapi.config.GlobalConfig.APIsGlobalConfigs;
import com.example.productapi.config.product.UpdateProductConfig;
import com.example.productapi.pojos.productPayloads.Request.ProductPayload;
import com.example.productapi.restAssuredApiCalls.RestAssuredApiCall;
import com.example.productapi.utils.jsontopojo.JsonUtils;
import com.github.javafaker.Faker;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import static com.example.productapi.config.product.UpdateProductConfig.FETCH_API_KEY_METHOD;


public class UpdateProductModule {
    private static final Faker faker = new Faker();
    public static ProductPayload expectedProductPayload;
    public static void sendPutRequestWithScenarioName(@NotNull String scenarioName){
                switch (scenarioName) {
                    case UpdateProductConfig.VALID_UPDATE_PRODUCT_TITLE_REQUEST:
                        String productId = APIsGlobalConfigs.RESPONSE_PRODUCT_ID;
                        if (productId.equals("")) {
                            productId = "7";
                        }
                        expectedProductPayload = updateProductTitle(FETCH_API_KEY_METHOD+"/"+productId);
                        System.out.println("Product Id Updated : " + APIsGlobalConfigs.RESPONSE_PRODUCT_ID);
                        break;
                    case UpdateProductConfig.INVALID_UPDATE_PRODUCT_DESCRIPTION_REQUEST:
                        expectedProductPayload = updateProductDescription(FETCH_API_KEY_METHOD+"/7");
                        break;

                    default:
                        throw new IllegalArgumentException("Unknown scenario name: " + scenarioName);
                }
            }

            private static ProductPayload updateProductTitle(@NotNull String methodName) {
                ProductPayload productPayload = new ProductPayload();
                productPayload.setTitle(faker.name().title());
                productPayload.setPrice(faker.number().randomNumber());
                productPayload.setDescription(faker.lorem().sentence());
                productPayload.setImage(faker.internet().image());
                productPayload.setCategory(faker.commerce().department());
                productPayload.setTitle(faker.name().title());
                RestAssuredApiCall.setup(APIsGlobalConfigs.BASE_URL);
                Response response = RestAssuredApiCall.putRequest(methodName,
                        String.valueOf(JsonUtils.objectToJsonString(productPayload)));
                APIsGlobalConfigs.HTTP_STATUS_CODE = response.getStatusCode();
                System.out.println("Response Status Code: " + response.getStatusCode());

                return productPayload;
            }

            private static ProductPayload updateProductDescription(@NotNull String methodName) {
                ProductPayload productPayload = new ProductPayload();
                productPayload.setTitle(faker.name().title());
                productPayload.setPrice(faker.number().randomNumber());
                productPayload.setDescription(faker.lorem().sentence());
                productPayload.setImage(faker.internet().image());
                productPayload.setCategory(faker.commerce().department());
                productPayload.setTitle(faker.name().title());
                productPayload.setDescription(faker.lorem().sentence());
                RestAssuredApiCall.setup(APIsGlobalConfigs.BASE_URL);
                Response response = RestAssuredApiCall.putRequest(methodName,
                        String.valueOf(JsonUtils.objectToJsonString(productPayload)));
                APIsGlobalConfigs.HTTP_STATUS_CODE = response.getStatusCode();
                System.out.println("Response Status Code: " + response.getStatusCode());

                return productPayload;
            }
    }

