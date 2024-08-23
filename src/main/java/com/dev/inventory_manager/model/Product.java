package com.dev.inventory_manager.model;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.validation.annotation.Validated;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "name_product")
    private String name;
    private Integer quantity;
    @Column(name = "price_product")
    private Double price;
    @Column(name = "cost_price")
    private Double costPrice;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "margin_%")
    private Double profitMargin;
}
