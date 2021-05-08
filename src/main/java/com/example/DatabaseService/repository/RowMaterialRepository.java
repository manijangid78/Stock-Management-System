package com.example.DatabaseService.repository;

import com.example.DatabaseService.model.RowMaterial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RowMaterialRepository extends JpaRepository<RowMaterial, Integer> {
    List<RowMaterial> findBySizeAndColor(Double size, String color);
    List<RowMaterial> findBySize(Double size);
    List<RowMaterial> findByColor(String color);
    List<RowMaterial> findBySizeAndGpmAndColorAndWeight(Double size, Double gpm, String color, double weight);
}
