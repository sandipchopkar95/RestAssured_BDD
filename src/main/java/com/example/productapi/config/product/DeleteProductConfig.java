package com.example.productapi.config.product;

public class DeleteProductConfig {
    //############### Scenario Name ##############################################
    /**
     * NOTE: These are cucumber scenario payload names, in case you modify these string values,
     * please remember to change equivalent strings in scenario feature files as well.
     */
    public static final String VALID_DELETE_PRODUCT_WITH_PRODUCT_ID_REQUEST = "Valid_Delete_Product_With_ProductId";
    public static final String INVALID_DELETE_PRODUCT_WITHOUT_PRODUCT_ID_REQUEST = "Invalid_Delete_Product_Without_ProductId";

    //########################### Method name # Endpoint #####################################
    public static final String FETCH_API_KEY_METHOD = "/products";

    //#########Response Key #######################################
    public static int PRODUCT_ID = 0;
    public static int TOTAL_PAGES = 0;
}
