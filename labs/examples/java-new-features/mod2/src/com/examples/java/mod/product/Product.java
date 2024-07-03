package com.examples.java.mod.product;

public class Product {
    private int id;
    private String category;
    private String description;
    private double price;

    public Product() {

    }

    public Product(int id, String category, String description, double price) {
        this.id = id;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
