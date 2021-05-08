package com.example.DatabaseService.service;

import com.example.DatabaseService.model.Product;
import com.example.DatabaseService.model.RowMaterial;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBService {

    private RowMaterialService rowMaterialService;
    private ProductService productService;

    @Autowired
    public DBService(RowMaterialService rowMaterialService, ProductService productService) {
        this.rowMaterialService = rowMaterialService;
        this.productService = productService;
    }

    public boolean addStock(RowMaterial rowMaterial){
        return rowMaterialService.addStock(rowMaterial);
    }

    public List<RowMaterial> searchRowMaterial(Double size, String color){
        List<RowMaterial> rowMaterials = rowMaterialService.getRowMaterial(size, color);
        return rowMaterials;
    }

    public boolean addProduct(Product product, RowMaterial rowMaterial){
        boolean bool = rowMaterialService.updateRowMaterial(rowMaterial.getSize(), rowMaterial.getColor(), rowMaterial.getStock());
        if(bool){
            return productService.addProduct(product);
        }
        return false;
    }

    public List<Product> searchProduct(Product product){
        return productService.searchProduct(product);
    }

    public List<Product> searchProductAll(){
        return productService.searchAll();
    }

    public List<RowMaterial> searchRowAll(){
        return rowMaterialService.searchAll();
    }

}
