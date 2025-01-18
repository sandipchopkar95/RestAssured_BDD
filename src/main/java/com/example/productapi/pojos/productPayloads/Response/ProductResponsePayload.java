package com.example.productapi.pojos.productPayloads.Response;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponsePayload {
    private int id;
    private String title;
    private Long price;
    private String  category;
    private String description;
    private String image;
}
