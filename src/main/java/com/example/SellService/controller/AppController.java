package com.example.SellService.controller;

import com.example.SellService.model.ProductInvoice;
import com.example.SellService.service.SellService;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppController {

    @Autowired
    private SellService sellService;


    @RequestMapping(value = "/sellProduct", method = RequestMethod.POST)
    public boolean addBill(@RequestBody String body){

        Gson gson = new Gson();
        JsonParser jsonParser = new JsonParser();
        JsonObject object = (JsonObject)jsonParser.parse(body);
        ProductInvoice productInvoice = gson.fromJson(object, ProductInvoice.class);
        System.out.println(productInvoice.toString());
        return sellService.addNewBill(productInvoice);
    }

    @RequestMapping(value = "/getInvoices", method = RequestMethod.GET)
    public List<ProductInvoice> getInvoices(){
        return sellService.getProductInvoice();
    }


}
