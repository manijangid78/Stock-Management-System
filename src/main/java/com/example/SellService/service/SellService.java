package com.example.SellService.service;

import com.example.SellService.model.Product;
import com.example.SellService.model.ProductInvoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SellService {

    private ProductInvoiceService productInvoiceService;
    private ProductService productService;

    @Autowired
    public SellService(ProductInvoiceService productInvoiceService, ProductService productService) {
        this.productInvoiceService = productInvoiceService;
        this.productService = productService;
    }

    public SellService() {
    }

    public boolean addNewBill(ProductInvoice productInvoice){
        Product product = new Product(productInvoice.getColor(), productInvoice.getWidth(), productInvoice.getHeight(),productInvoice.getStock());

        if(productService.getProductDetails(product)){
            return productInvoiceService.addNewBill(productInvoice);
        }
        return false;
    }

    public List<ProductInvoice> getProductInvoice(){
        return productInvoiceService.getAllInvoices();
    }

}
