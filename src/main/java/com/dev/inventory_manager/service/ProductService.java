package com.dev.inventory_manager.service;

import com.dev.inventory_manager.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public void saveProduct(Product product);
    public List<Product> findAll();
    public Optional<Product> findById(Integer id);
    public void deleteProduct(Integer id);
}
