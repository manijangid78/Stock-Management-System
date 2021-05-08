package com.example.SellService.service;

import com.example.SellService.model.Product;
import com.example.SellService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public boolean getProductDetails(Product product){
        try {
            System.out.println(product.toString());
            List<Product> productList = productRepository.findByColorAndWidthAndHeight(product.getColor().toLowerCase(), product.getWidth(), product.getHeight());
            System.out.println(productList.size());
            Product product1 = productList.get(0);
            System.out.println(product1.toString());
            product1.setCreatedProduct(product1.getCreatedProduct()-product.getCreatedProduct());
            System.out.println(product1.toString());
            productRepository.save(product1);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

}
