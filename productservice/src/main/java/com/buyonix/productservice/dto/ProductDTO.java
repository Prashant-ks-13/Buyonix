package com.buyonix.productservice.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.apache.logging.log4j.message.Message;

import java.math.BigDecimal;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    @NotBlank(message = "Name is required")
    private String name;
    @NotBlank(message = "sku is required")
    private String sku;
    private String description;
    private BigDecimal price;
    private boolean active;
    private String imageurl;


}
