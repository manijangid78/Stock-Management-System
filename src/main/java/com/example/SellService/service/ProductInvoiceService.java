package com.example.SellService.service;

import com.example.SellService.model.ProductInvoice;
import com.example.SellService.repository.ProductInvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductInvoiceService {

    @Autowired
    private ProductInvoiceRepository productInvoiceRepository;

    public boolean addNewBill(ProductInvoice productInvoice){
        try{
            productInvoice.setColor(productInvoice.getColor().toLowerCase());
            productInvoiceRepository.save(productInvoice);
            return true;
        }catch (Exception e){
            System.out.println(e);
            return false;
        }
    }

    public List<ProductInvoice> getAllInvoices(){
        try {
            return productInvoiceRepository.findAllByOrderByDateAsc();
        }catch (Exception e){
            System.out.println(e);
            return null;
        }
    }

}
