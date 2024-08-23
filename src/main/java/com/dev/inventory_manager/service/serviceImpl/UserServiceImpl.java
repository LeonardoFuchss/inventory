package com.dev.inventory_manager.service.serviceImpl;

import com.dev.inventory_manager.exceptions.UserAlreadyExist;
import com.dev.inventory_manager.model.User;
import com.dev.inventory_manager.repositories.UserRepository;
import com.dev.inventory_manager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Override
    public void save(User user) {
        User userFind = userRepository.findByEmail(user.getEmail());

        if (userFind == null) {
            userRepository.save(user);
        } else {
            throw new UserAlreadyExist("User already exist!");
        }
    }

    @Override
    public User authenticate(String user, String password) {
        User userFind = userRepository.findByUser(user);
        User userFindPassword = userRepository.findByPassword(password);
        if (userFind != null && userFindPassword != null){
            return userFindPassword;
        } else {
            throw new UserAlreadyExist("User not exist");
        }
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteProduct(Integer id) {
    }
}
