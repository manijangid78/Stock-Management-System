package com.example.DatabaseService.repository;

import com.example.DatabaseService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByWidthAndHeightAndColor(double width, double height, String color);
    List<Product> findByColor(String color);
    List<Product> findByWidthAndHeight(Double width, Double height);
}
