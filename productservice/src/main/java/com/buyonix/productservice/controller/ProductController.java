package com.buyonix.productservice.controller;


import com.buyonix.productservice.dto.ProductDTO;
import com.buyonix.productservice.model.Product;
import com.buyonix.productservice.response.ProductResponse;
import com.buyonix.productservice.service.ProductServiceImpl;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    public ProductController(ProductServiceImpl productService) {
        this.productService = productService;
    }

    private final ProductServiceImpl productService;

    @PostMapping("/addProduct")
    private ResponseEntity<ProductResponse> addProduct(@Valid @RequestBody ProductDTO productDTO){

        ProductResponse response = productService.saveProduct(productDTO);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/allProduct")
    List<Product> getAllProduct(){
        return productService.getAll();
    }

    @PutMapping("/updateProduct/{id}")
    private Object updateProduct(@RequestBody Product product,@PathVariable String id){
        try {
            return productService.updateProduct(product,id);
        }catch (Exception e){
            return e.getMessage();
        }
    }

    @DeleteMapping("/deleteAll")
    private void deleteAll(){
        productService.deleteAll();
    }
}
