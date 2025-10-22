package com.buyonix.productservice.service;


import com.buyonix.productservice.exceptions.ProductNotFoundException;
import com.buyonix.productservice.model.Product;
import com.buyonix.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long prodid) {
        Optional<Product> existingProduct = productRepository.findById(prodid);
        if(!existingProduct.isPresent()){
            throw new ProductNotFoundException("No Product found with ID = "+prodid);
        }else{
            return  productRepository.save(product);
        }

    }

    @Override
    public void deleteAll() {
        productRepository.deleteAll();
    }
}
