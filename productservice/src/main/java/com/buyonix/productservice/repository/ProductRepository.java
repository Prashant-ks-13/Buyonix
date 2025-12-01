package com.buyonix.productservice.repository;

import com.buyonix.productservice.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface ProductRepository extends MongoRepository<Product,String> {
    Optional<Product> findBySku(String sku);
    boolean existsBySku(String sku);
}
