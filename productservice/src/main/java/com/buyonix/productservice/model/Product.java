package com.buyonix.productservice.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.Instant;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    /**
     * Using String for id is convenient with Spring Data MongoDB.
     * Mongo will store an ObjectId string here unless you explicitly set it.
     */
    @Id
    private String id;

    @Field("product_name")
    private String name;

    /**
     * Unique index on sku to mimic your unique constraint
     */
    @Indexed(name = "sku_unique", unique = true)
    private String sku;

    @Field("product_description")
    private String description;

    private BigDecimal price;

    private boolean active;

    private String imageurl;

    /**
     * Use Instant for timestamps. Populate automatically via auditing.
     */
    @CreatedDate
    private Instant created;

    @LastModifiedDate
    private Instant lastUpdated;
}
