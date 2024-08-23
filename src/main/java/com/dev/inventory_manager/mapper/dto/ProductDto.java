package com.dev.inventory_manager.mapper.dto;

import com.dev.inventory_manager.model.Product;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductDto {

    private String name;
    private Integer quantity;
    private Double totalPrice;
    private Double costPrice;
    private Double profit_margin;
    private Double price;

}
