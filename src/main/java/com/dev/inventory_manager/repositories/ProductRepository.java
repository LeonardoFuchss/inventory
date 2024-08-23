package com.dev.inventory_manager.repositories;

import com.dev.inventory_manager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    public Product findByname(String name);
}
