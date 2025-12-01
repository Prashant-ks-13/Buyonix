package com.buyonix.productservice.model;


import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.math.BigDecimal;
import java.time.Instant;

@Document(collection = "products")
@CompoundIndexes({
        @CompoundIndex(name = "name_sku_unique", def = "{'name': 1, 'sku': 1}", unique = true)
})
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

    public String getName() {
        return name;
    }
}
