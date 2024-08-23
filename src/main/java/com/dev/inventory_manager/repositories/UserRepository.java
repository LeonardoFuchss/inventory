package com.dev.inventory_manager.repositories;

import com.dev.inventory_manager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByEmail(String email);
    public User findByUser(String user);
    public User findByPassword(String password);
}
