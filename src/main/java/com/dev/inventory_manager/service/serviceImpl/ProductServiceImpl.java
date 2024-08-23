package com.dev.inventory_manager.service.serviceImpl;

import com.dev.inventory_manager.exceptions.UserAlreadyExist;
import com.dev.inventory_manager.model.Product;
import com.dev.inventory_manager.repositories.ProductRepository;
import com.dev.inventory_manager.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void saveProduct(Product product) {
        Product productFind = productRepository.findByname(product.getName());
        if (productFind != null) {
            updateProductExisting(productFind, product);
            productRepository.save(productFind);
        } else {
            setValuesProduct(product);
            productRepository.save(product);
        }
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        Optional<Product> productFind = productRepository.findById(id);
        if (productFind.isPresent()) {
            return productFind;
        } else {
            throw new UserAlreadyExist("The product not exist!");
        }
    }

    @Override
    public void deleteProduct(Integer id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            productRepository.deleteById(id);
        } else {
            throw new UserAlreadyExist("The product not exist!");
        }
    }
    private void updateProductExisting(Product newProduct, Product product) { /* Atualização de valores dos produtos (caso ele existir) */
        newProduct.setQuantity(newProduct.getQuantity() + product.getQuantity());
        newProduct.setTotalPrice(newProduct.getPrice() * newProduct.getQuantity());
    }
    private void setValuesProduct(Product product) { /* Calcula margem de lucro com base na quantidade e no preço do produto */
        product.setTotalPrice(product.getPrice() * product.getQuantity()); /* Calcula preço total */
        double profitMargin = ((product.getPrice() - product.getCostPrice()) / product.getPrice()) * 100; /* Calcula a margin de lucro (porcentagem) */
        double profitAround = Math.round(profitMargin * 100.0) / 100.0; /* Arredondamento */
        product.setProfitMargin(profitAround);
    }
}
