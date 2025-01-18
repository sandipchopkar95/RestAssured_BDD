package com.example.productapi.utils.jsontopojo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.HashMap;
//import org.cellulant.checkoutapis.pojos.chargerequest.request.ChargeRequestPayload;

public class JsonToPojo {
    static HashMap<String, Object> payloadHasMap;

    public static @NotNull ObjectMapper configureJacksonObjectMapper(){
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

        return mapper;
    }

    @Contract("_ -> new")
    public static @NotNull File getFileFromResource(String fileName) throws URISyntaxException {
        ClassLoader classLoader = JsonToPojo.class.getClassLoader();
        URL resource = classLoader.getResource(fileName);
        if (resource == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return new File(resource.toURI());
        }
    }

    public static Object JSONToPojo(String JSONFilePath) throws URISyntaxException {
        // create instance of the File class
        File fileObj = getFileFromResource(JSONFilePath);
        Object pojoObj = new Object();
        try {

            switch (JSONFilePath){
//                case CREATE_SERVICE_REQUEST_PAYLOAD_JSON_PATH:
//                    pojoObj = configureJacksonObjectMapper().readValue(fileObj, CreateServiceRequest.class);
//                    break;
//
//                case CREATE_API_KEY_REQUEST_PAYLOAD_JSON_PATH:
//                    pojoObj = configureJacksonObjectMapper().readValue(fileObj, CreateAPIKeyRequest.class);
//                    break;
//
//                case UPDATE_SERVICE_ATTRIBUTE_MAPPING_PAYLOAD_JSON_PATH:
//                    pojoObj = configureJacksonObjectMapper().readValue(fileObj, UpdateServiceAttributeMappingRequest.class);
//                    break;
//
//                case ACTIVATE_AND_DEACTIVATE_USER_API_KEY_REQUEST_PAYLOAD_JSON_PATH:
//                    pojoObj = configureJacksonObjectMapper().readValue(fileObj, ActivateAndDeactivateUserAPIKeyRequest.class);
//                    break;
//
//                case CHECKOUT_PAYLOAD_JSON_PATH:
//                    pojoObj = configureJacksonObjectMapper().readValue(fileObj, CheckoutRequest.class);
//                    break;
//
//                case CHARGE_REQUEST_JSON_PATH:
//                    pojoObj = configureJacksonObjectMapper().readValue(fileObj, ChargeRequestPayload.class);
//                    break;
//
//                case PL_ACTIVATE_DEACTIVATE_REQUEST:
//                    pojoObj = configureJacksonObjectMapper().readValue(fileObj, ActivateDeactivatePaymentOptionRequestPayload.class);
//                    break;
//                case PL_FETCH_PAYMENT_OPTIONS_DETAILS:
//                    pojoObj = configureJacksonObjectMapper().readValue(fileObj, FetchPaymentOptionsDetailsRequestPayload.class);
//                    break;
//                case PAYMENT_SIMULATION_REQUEST_PAYLOAD_JSON_PATH:
//                    pojoObj = configureJacksonObjectMapper().readValue(fileObj, PaymentSimulationRequest.class);
//                    break;
//
//                case SAVE_NEW_PAYMENT_ACK_REQUEST_PAYLOAD_JSON_PATH:
//                    pojoObj=configureJacksonObjectMapper().readValue(fileObj, SaveNewPaymentAcknowledgementRequest.class);
//                    break;
//
//                case PAYMENT_REFUND_REQUEST_PAYLOAD_JSON_PATH:
//                    pojoObj=configureJacksonObjectMapper().readValue(fileObj, InitiatePaymentRefundRequest.class);
//                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + JSONFilePath);
            }
        } catch (Exception e) {
            // show error message
            e.printStackTrace();
        }

        return pojoObj;
    }
}

