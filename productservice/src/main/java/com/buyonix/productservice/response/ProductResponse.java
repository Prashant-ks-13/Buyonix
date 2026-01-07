package com.buyonix.productservice.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ProductResponse <T>{
    private String name;
    private boolean active;
    private String message;
    private T data;

    public void setMessage(String message) {
        this.message = message;
    }
}
