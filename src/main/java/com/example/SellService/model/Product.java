package com.example.SellService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;
    private double width;
    private double height;
    private int createdProduct;
    private String color;

    public Product(String color,double width, double height, int createdProduct) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.createdProduct = createdProduct;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCreatedProduct() {
        return createdProduct;
    }

    public void setCreatedProduct(int createdProduct) {
        this.createdProduct = createdProduct;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", width=" + width +
                ", height=" + height +
                ", createdProduct=" + createdProduct +
                ", color='" + color + '\'' +
                '}';
    }
}
