package com.example.productapi.pojos.productPayloads.Request;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductPayload {
    private String title;
    private Long price;
    private String description;
    private String image;
    private String category;
    //private Attributes attributes; // Nested object

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Attributes {
        private String small;
        private String medium;
        private String large;
    }
}
