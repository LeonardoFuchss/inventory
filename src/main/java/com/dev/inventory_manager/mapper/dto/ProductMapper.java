package com.dev.inventory_manager.mapper.dto;

import com.dev.inventory_manager.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.Mapping;

@Component
public class ProductMapper {
    public Product toEntity(ProductDto productDto) {

        return Product.builder()
                .name(productDto.getName())
                .quantity(productDto.getQuantity())
                .price(productDto.getPrice())
                .totalPrice(productDto.getTotalPrice())
                .profitMargin(productDto.getProfit_margin())
                .costPrice(productDto.getCostPrice())
                .build();
    }
}
