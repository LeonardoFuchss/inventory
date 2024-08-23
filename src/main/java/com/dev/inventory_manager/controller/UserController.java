package com.dev.inventory_manager.controller;


import com.dev.inventory_manager.mapper.dto.ProductDto;
import com.dev.inventory_manager.mapper.dto.ProductMapper;
import com.dev.inventory_manager.mapper.dto.UserDto;
import com.dev.inventory_manager.mapper.dto.UserMapper;
import com.dev.inventory_manager.model.Product;
import com.dev.inventory_manager.model.User;
import com.dev.inventory_manager.service.UserService;
import com.dev.inventory_manager.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/save")
    public ResponseEntity<?> saveUser(@RequestBody UserDto userDto) {
        User user = userMapper.toEntity(userDto);
        userService.save(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }
    @PostMapping("/authenticate")
    public ResponseEntity<User> authenticate(@RequestBody User user) {
        User userFind = userService.authenticate(user.getUser(), user.getPassword());
        if (userFind != null) {
            return ResponseEntity.ok().body(userFind);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}