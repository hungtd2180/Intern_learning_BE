package com.example.demospring.sevices;

import com.example.demospring.models.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    void save(Product product);
    void delete(Long id);
    Optional<Product> findById(Long id);
    List<Product> findAll();
}
