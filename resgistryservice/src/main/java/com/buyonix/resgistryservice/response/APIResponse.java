package com.buyonix.resgistryservice.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class APIResponse<T> {

    private boolean success;
    private int statusCode;
    private String message;
    private T data;
}
