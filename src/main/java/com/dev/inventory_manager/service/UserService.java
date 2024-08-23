package com.dev.inventory_manager.service;

import com.dev.inventory_manager.model.Product;
import com.dev.inventory_manager.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public void save(User user);
    public User authenticate(String user, String password);
    public List<User> findAll();
    public Optional<User> findById(Integer id);
    public void deleteProduct(Integer id);
}
