package com.example.demo;

public class Item {
    private String category;
    private String type;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    private String brand;
    private double price;

    public Item(String category, String type, double price) {
        this.category = category;
        this.type = type;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }
}
