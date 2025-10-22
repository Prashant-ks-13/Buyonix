package com.buyonix.productservice.service;

import com.buyonix.productservice.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product saveProduct(Product product);
    Product updateProduct(Product product,Long prodid);
    void deleteAll();
}
