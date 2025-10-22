package com.buyonix.productservice.controller;


import com.buyonix.productservice.model.Product;
import com.buyonix.productservice.service.ProductServiceImpl;
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
    private Product addProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @GetMapping("/allProduct")
    List<Product> getAllProduct(){
        return productService.getAll();
    }

    @PutMapping("/updateProduct/{id}")
    private Object updateProduct(@RequestBody Product product,@PathVariable Long id){
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
