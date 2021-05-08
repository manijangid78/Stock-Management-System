package com.example.DatabaseService.service;

import com.example.DatabaseService.model.Product;
import com.example.DatabaseService.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public boolean addProduct(Product product){
        try{
            List<Product> products = productRepository.findByWidthAndHeightAndColor(product.getWidth(), product.getHeight(), product.getColor().toLowerCase());
            if(products.size()>0){
                products.get(0).setCreatedProduct(products.get(0).getCreatedProduct()+product.getCreatedProduct());
                productRepository.save(products.get(0));
            }else{
                product.setColor(product.getColor().toLowerCase());
                productRepository.save(product);
            }
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public List<Product> searchProduct(Product product){
        try {
            if(product.getHeight()==0.0 && product.getWidth() == 0.0){
                return productRepository.findByColor(product.getColor());
            }else if(product.getColor().equals("")){
                return productRepository.findByWidthAndHeight(product.getWidth(), product.getHeight());
            }
            return productRepository.findByWidthAndHeightAndColor(product.getWidth(), product.getHeight(), product.getColor());
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

    public List<Product> searchAll(){
        try{
            return productRepository.findAll();
        }catch (Exception e){
            System.out.println(e);
        }
        return null;
    }

}
