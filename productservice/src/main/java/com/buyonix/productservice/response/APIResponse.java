package com.buyonix.productservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class APIResponse<T> {

    private boolean success;
    private int statusCode;
    private String message;
    private T data;


}
