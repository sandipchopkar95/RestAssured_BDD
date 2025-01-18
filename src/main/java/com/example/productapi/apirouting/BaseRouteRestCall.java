package com.example.productapi.apirouting;

import com.example.productapi.modules.products.DeleteProductModule;
import com.example.productapi.modules.products.UpdateProductModule;
import org.jetbrains.annotations.NotNull;

import com.example.productapi.modules.products.FetchProductModule;
import com.example.productapi.modules.products.CreateProductModule;

import static com.example.productapi.config.GlobalConfig.APIsGlobalConfigs.PRODUCT_MODULE;

public class BaseRouteRestCall {

    public static void routePOSTCallWithModuleAndScenarioName(@NotNull String moduleName, @NotNull String scenarioName) {

        switch (moduleName) {
            case PRODUCT_MODULE:
                CreateProductModule.sendCreateRequestWithScenarioName(scenarioName);
                break;

            default:
                System.out.println("Default Module Name"+ "Module Name: " + moduleName + " and Scenario Name: " + scenarioName);
        }
    }

    public static void routeGETRequestWithModuleAndScenarioName(@NotNull String moduleName, @NotNull String scenarioName) {
        switch (moduleName) {
            case PRODUCT_MODULE:
                FetchProductModule.sendGetRequestWithScenarioName(scenarioName);
                break;

            default:
                System.out.println("Default Module Name"+ "Module Name: " + moduleName + " and Scenario Name: " + scenarioName);
        }
    }

    public static void routePUTRequestWithModuleAndScenarioName(@NotNull String moduleName, @NotNull String scenarioName) {
        switch (moduleName) {
            case PRODUCT_MODULE:
                UpdateProductModule.sendPutRequestWithScenarioName(scenarioName);
                break;

            default:
                System.out.println("Default Module Name"+ "Module Name: " + moduleName + " and Scenario Name: " + scenarioName);
        }
    }

    public static void routeDELETERequestWithModuleAndScenarioName(@NotNull String moduleName, @NotNull String scenarioName) {
        switch (moduleName) {
            case PRODUCT_MODULE:
                DeleteProductModule.sendDELETERequestWithScenarioName(scenarioName);
                break;

            default:
                System.out.println("Default Module Name"+ "Module Name: " + moduleName + " and Scenario Name: " + scenarioName);
        }
    }


}
