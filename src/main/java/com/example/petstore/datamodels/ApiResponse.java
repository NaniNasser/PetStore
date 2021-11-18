package com.example.petstore.datamodels;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {
    private Integer code;
    private String type;
    private String message;

}
