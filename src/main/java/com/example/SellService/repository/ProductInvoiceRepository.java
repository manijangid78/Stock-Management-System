package com.example.SellService.repository;

import com.example.SellService.model.ProductInvoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInvoiceRepository extends JpaRepository<ProductInvoice, Integer> {
    List<ProductInvoice> findAllByOrderByDateAsc();
}
