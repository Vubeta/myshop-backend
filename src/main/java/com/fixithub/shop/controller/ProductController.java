package com.fixithub.shop.controller;

import com.fixithub.shop.entity.Product;
import com.fixithub.shop.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:5173") // cho phép React truy cập
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

//    @PostMapping
//    public Product create(@RequestBody Product product) {
//        return productService.saveProduct(product);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        productService.deleteProduct(id);
//    }
}
