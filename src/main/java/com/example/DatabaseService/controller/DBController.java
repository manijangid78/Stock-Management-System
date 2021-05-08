package com.example.DatabaseService.controller;

import com.example.DatabaseService.model.Product;
import com.example.DatabaseService.model.RowMaterial;
import com.example.DatabaseService.service.DBService;
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
public class DBController {

    private DBService dbService;

    @Autowired
    public DBController(DBService dbService) {
        this.dbService = dbService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String get(){
        return "Hello";
    }

    @RequestMapping(value = "/addStock", method = RequestMethod.POST, consumes = "application/json")
    public boolean addStock(@RequestBody String rowMaterial){
        try{
            // String format converted to RowMaterial Object using json
            Gson gson = new Gson();
            JsonParser parser = new JsonParser();
            JsonObject object = (JsonObject) parser.parse(rowMaterial);// response will be the json String
            RowMaterial rowMaterial1 = gson.fromJson(object, RowMaterial.class);
            dbService.addStock(rowMaterial1);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/searchRowMaterial", method = RequestMethod.POST, consumes = "application/json")
    public List<RowMaterial> searchRowMaterial(@RequestBody String body){
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(body);// response will be the json String
        RowMaterial rowMaterial = gson.fromJson(object, RowMaterial.class);
        return dbService.searchRowMaterial(rowMaterial.getSize(), rowMaterial.getColor());
    }

    @RequestMapping(value = "/addProduct", method = RequestMethod.POST, consumes = "application/json")
    public boolean addProduct(@RequestBody String body){

        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(body);
        Product product = gson.fromJson(object, Product.class);
        RowMaterial rowMaterial = gson.fromJson(object, RowMaterial.class);
        return dbService.addProduct(product,rowMaterial);
    }

    @RequestMapping(value = "/searchProduct", method = RequestMethod.POST, consumes = "application/json")
    public List<Product> searchProduct(@RequestBody String body){
        Gson gson = new Gson();
        JsonParser parser = new JsonParser();
        JsonObject object = (JsonObject) parser.parse(body);
        Product product = gson.fromJson(object, Product.class);
        return dbService.searchProduct(product);
    }

    @RequestMapping(value = "/searchProductAll", method = RequestMethod.GET)
    public List<Product> searchProductAll(){
        return dbService.searchProductAll();
    }

    @RequestMapping(value = "/searchRowAll", method = RequestMethod.GET)
    public List<RowMaterial> searchRowAll(){
        return dbService.searchRowAll();
    }

}
