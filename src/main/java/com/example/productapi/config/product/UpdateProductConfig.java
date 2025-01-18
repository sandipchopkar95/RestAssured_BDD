package com.example.productapi.config.product;

public class UpdateProductConfig {
    //############### Scenario Name ##############################################
    /**
     * NOTE: These are cucumber scenario payload names, in case you modify these string values,
     * please remember to change equivalent strings in scenario feature files as well.
     */
    public static final String VALID_UPDATE_PRODUCT_TITLE_REQUEST = "Valid_Update_Product_Title_Request";
    public static final String INVALID_UPDATE_PRODUCT_DESCRIPTION_REQUEST = "Valid_Update_Product_Description_Request";



    //########################### Method name # Endpoint #####################################
    public static final String FETCH_API_KEY_METHOD = "/products";

    //#########Response Key #######################################
    public static int PRODUCT_ID = 0;
    public static int TOTAL_PAGES = 0;
}
