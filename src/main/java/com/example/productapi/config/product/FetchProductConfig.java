package com.example.productapi.config.product;

public class FetchProductConfig {
    //############### Scenario Name ##############################################
    /**
     * NOTE: These are cucumber scenario payload names, in case you modify these string values,
     * please remember to change equivalent strings in scenario feature files as well.
     */
    public static final String VALID_GET_PRODUCT_REQUEST = "Valid_Get_Product_Request";
    public static final String INVALID_GET_PRODUCT_REQUEST = "Invalid_Get_Product_Request";
    public static final String VALID_GET_SINGLE_PRODUCT_REQUEST="Valid_Get_Single_Product";

    public static final String VALID_CREATE_PRODUCT_REQUEST = "Valid_Create_Product_Request";
    public static final String VALID_UPDATE_PRODUCT_REQUEST = "Valid_Update_Product_Request";
    public static final String VALID_DELETE_PRODUCT_REQUEST = "Valid_Delete_Product_Request";


    //########################### Method name # Endpoint #####################################
    public static final String FETCH_API_KEY_METHOD = "/products";

    //#########Response Key #######################################
    public static int PRODUCT_ID = 0;
    public static int TOTAL_PAGES = 0;
}
