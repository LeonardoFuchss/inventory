package com.dev.inventory_manager.controller;

import com.dev.inventory_manager.mapper.dto.ProductDto;
import com.dev.inventory_manager.mapper.dto.ProductMapper;
import com.dev.inventory_manager.model.Product;
import com.dev.inventory_manager.service.serviceImpl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    private ProductMapper productMapper;

    @PostMapping("/save")
    public ResponseEntity<?> saveProduct(@RequestBody ProductDto productDto){
            Product product = productMapper.toEntity(productDto);
            productService.saveProduct(product);
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }
    @GetMapping("/find")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> productsFind = productService.findAll();
        return ResponseEntity.ok(productsFind);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Product>> findById (@PathVariable Integer id){
        Optional<Product> product = productService.findById(id);
        return ResponseEntity.ok(product);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        productService.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}
