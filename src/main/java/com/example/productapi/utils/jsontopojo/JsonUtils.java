package com.example.productapi.utils.jsontopojo;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {
    // Method to convert any object to a JSON string using Jackson ObjectMapper
    public static String objectToJsonString(Object object) {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = objectMapper.writeValueAsString(object);  // Serialize object to JSON string
        } catch (Exception e) {
            e.printStackTrace();
            // You can log the error or throw a custom exception based on your preference
        }
        return jsonString;
    }
}
