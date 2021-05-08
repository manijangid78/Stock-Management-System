package com.example.SellService.repository;

import com.example.SellService.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByColorAndWidthAndHeight(String color, Double width, Double height);

}
