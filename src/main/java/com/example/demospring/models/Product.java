package com.example.demospring.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    private String productName;
    private Long number;
    private String image;
    private String description;
}
