package com.buyonix.productservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tbl_product",schema = "productdetails", uniqueConstraints =
        {@UniqueConstraint(name = "sku_unique",columnNames = "sku")})
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "product_sequence")
    @SequenceGenerator(name = "product_sequence",sequenceName = "product_sequence_name",allocationSize = 1)
    private Long id;
    @Column(name = "product_name",nullable = false)
    private String name;
    @Column(nullable = false)
    private String sku;
    @Column(name = "product_description",nullable = false)
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    private boolean active;
    private String imageurl;

    @CreationTimestamp
    private String created;
    @UpdateTimestamp
    private String lastupdated;

}
