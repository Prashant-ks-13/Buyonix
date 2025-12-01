package com.buyonix.productservice.service;

import com.buyonix.productservice.dto.ProductDTO;
import com.buyonix.productservice.model.Product;
import com.buyonix.productservice.response.ProductResponse;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    ProductResponse saveProduct(ProductDTO productDTO);
    Product updateProduct(Product product,String prodid);
    void deleteAll();
}
