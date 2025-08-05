package com.automationteststore.model;

public class Product {
    private final String name;
    private final double price;
    private final String category;
    private final String subCategory;

    public Product(String name, double price, String category, String subCategory) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public String getSubCategory() {
        return subCategory;
    }
}
