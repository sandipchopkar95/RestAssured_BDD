package com.example.productapi.config.product;

public class CreateProductConfig {
    //############### Scenario Name ##############################################
    /**
     * NOTE: These are cucumber scenario payload names, in case you modify these string values,
     * please remember to change equivalent strings in scenario feature files as well.
     */
    public static final String VALID_CREATE_PRODUCT_REQUEST = "Valid_Create_Product_Request";
    public static final String INVALID_CREATE_PRODUCT_REQUEST_EMPTY_TITLE = "Invalid_Create_Product_Request_Empty_Title";



    //########################### Method name # Endpoint #####################################
    public static final String FETCH_API_KEY_METHOD = "/products";

    //#########Response Key #######################################
    public static int PRODUCT_ID = 0;
    public static int TOTAL_PAGES = 0;
}
