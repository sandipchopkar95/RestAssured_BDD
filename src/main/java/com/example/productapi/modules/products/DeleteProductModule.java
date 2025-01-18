package com.example.productapi.modules.products;

import com.example.productapi.config.GlobalConfig.APIsGlobalConfigs;
import com.example.productapi.config.product.DeleteProductConfig;
import com.example.productapi.restAssuredApiCalls.RestAssuredApiCall;
import io.restassured.response.Response;
import org.jetbrains.annotations.NotNull;

import static com.example.productapi.config.product.DeleteProductConfig.FETCH_API_KEY_METHOD;

public class DeleteProductModule {

    public static void sendDELETERequestWithScenarioName(String scenarioName) {
        switch (scenarioName) {
            case DeleteProductConfig.VALID_DELETE_PRODUCT_WITH_PRODUCT_ID_REQUEST:
                String productId = APIsGlobalConfigs.RESPONSE_PRODUCT_ID;
                if (productId.equals("")) {
                    productId = "7";
                }
                deleteProduct(FETCH_API_KEY_METHOD + "/" + productId);
                System.out.println("Product Id Deleted : " + APIsGlobalConfigs.RESPONSE_PRODUCT_ID);
                break;
            case DeleteProductConfig.INVALID_DELETE_PRODUCT_WITHOUT_PRODUCT_ID_REQUEST:
                deleteProduct(FETCH_API_KEY_METHOD);
                break;

            default:
                throw new IllegalArgumentException("Unknown scenario name: " + scenarioName);
        }
    }

    private static void deleteProduct(@NotNull String methodName) {
        RestAssuredApiCall.setup(APIsGlobalConfigs.BASE_URL);
        Response response = RestAssuredApiCall.deleteRequest(methodName);
        APIsGlobalConfigs.HTTP_STATUS_CODE = response.getStatusCode();
        System.out.println("Response Status Code: " + response.getStatusCode());
    }

}

