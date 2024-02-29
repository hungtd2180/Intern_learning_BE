package com.example.demospring.controller;

import com.example.demospring.models.Product;
import com.example.demospring.sevices.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api")
public class APIProductController {
    @Autowired
    IProductService productService;

    @GetMapping("/products")
    public ResponseEntity<?> getAllProducts(){
        List<Product> products = productService.findAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/products/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        Optional<Product> product = productService.findById(id);
        if (product.isEmpty()){
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }
    @PostMapping("/products")
    public ResponseEntity<?> addProduct(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PutMapping("/products")
    public ResponseEntity<?> updateProduct(@RequestBody Product product){
        productService.save(product);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @DeleteMapping("/products/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
