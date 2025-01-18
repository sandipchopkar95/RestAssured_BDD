package com.example.productapi.modules.products;

import com.example.productapi.config.GlobalConfig.APIsGlobalConfigs;
import com.example.productapi.config.product.FetchProductConfig;
import com.example.productapi.restAssuredApiCalls.RestAssuredApiCall;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

public class FetchProductModule {

    public static void sendGetRequestWithScenarioName(@NotNull String scenarioName) {
        switch (scenarioName) {
            case FetchProductConfig.VALID_GET_PRODUCT_REQUEST:
                fetchTotalProducts(FetchProductConfig.FETCH_API_KEY_METHOD);
                break;
            case FetchProductConfig.INVALID_GET_PRODUCT_REQUEST:
                String methodName = "/product";
                fetchTotalProducts(methodName);
                break;
            case FetchProductConfig.VALID_GET_SINGLE_PRODUCT_REQUEST:
                String productId = APIsGlobalConfigs.RESPONSE_PRODUCT_ID;
                if (productId.equals("")) {
                    productId = "7";
                }
                fetchSingleProducts(FetchProductConfig.FETCH_API_KEY_METHOD+"/"+productId);
                System.out.println("Product Id Fetch : " + APIsGlobalConfigs.RESPONSE_PRODUCT_ID);
                break;
            default:
                System.out.println("Default Scenario " + scenarioName);
        }
    }

    private static void fetchTotalProducts(@NotNull String methodName) {
        //setup REST API base URL
        RestAssuredApiCall.setup(APIsGlobalConfigs.BASE_URL);
        //send GET request
        Response response = RestAssuredApiCall.getRequest(methodName);
        //fetch HTTP response code
        APIsGlobalConfigs.HTTP_STATUS_CODE = response.getStatusCode();
    }

    private static void fetchSingleProducts(@NotNull String methodName) {
        //setup REST API base URL
        RestAssuredApiCall.setup(APIsGlobalConfigs.BASE_URL);
        //send GET request
        Response response = RestAssuredApiCall.getRequest(methodName );
        //fetch HTTP response code
        APIsGlobalConfigs.HTTP_STATUS_CODE = response.getStatusCode();
    }
}
