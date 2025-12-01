package com.buyonix.productservice.service;


import com.buyonix.productservice.dto.ProductDTO;
import com.buyonix.productservice.exceptions.DuplicateProductException;
import com.buyonix.productservice.exceptions.ProductNotFoundException;
import com.buyonix.productservice.mapper.ProductMapper;
import com.buyonix.productservice.model.Product;
import com.buyonix.productservice.repository.ProductRepository;
import com.buyonix.productservice.response.ProductResponse;
import com.mongodb.DuplicateKeyException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;



    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductResponse saveProduct(ProductDTO productDTO) {
        if(productRepository.existsByNameAndSku(productDTO.getName(),productDTO.getSku())){
            throw new DuplicateProductException("Product with name : "+productDTO.getName()+" and sku : "+productDTO.getSku()+" already exists.");
        }
        try {
            Product product = productMapper.toProduct(productDTO);
            productRepository.save(product);
            ProductResponse productResponse = productMapper.toResponse(product);
            productResponse.setMessage("Product " +product.getName()+" has been added to the DataBase");
            return productResponse;
        } catch (DuplicateKeyException ex) {
            throw new DuplicateProductException("Product with name : "+productDTO.getName()+" and sku : "+productDTO.getSku()+" already exists.");
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Override
    public Product updateProduct(Product product, String prodid) {
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
