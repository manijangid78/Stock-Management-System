package com.example.DatabaseService.model;

import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
public class RowMaterial {

    @Id
    @GeneratedValue
    private int id;
    private double size;
    private double weight;
    private double gpm;
    private String color;
    private int stock;

    public RowMaterial(int id, double size, double weight, double gpm, String color, int stock) {
        this.id = id;
        this.size = size;
        this.weight = weight;
        this.gpm = gpm;
        this.color = color;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getGpm() {
        return gpm;
    }

    public void setGpm(double gpm) {
        this.gpm = gpm;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "RowMaterial{" +
                "size=" + size +
                ", weight=" + weight +
                ", gpm=" + gpm +
                ", color='" + color + '\'' +
                ", stock=" + stock +
                '}';
    }
}
