package com.example.demospring.sevices;

import com.example.demospring.models.Product;
import com.example.demospring.repositoies.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService{
    @Autowired
    private IProductRepository productRepository;
    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
