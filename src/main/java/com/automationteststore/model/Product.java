package com.automationteststore.model;

import java.util.Objects;

public class Product {
    private String name;
    private double price;
    private String category;
    private String subCategory;

    public Product(String name, double price, String category, String subCategory) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(String subCategory) {
        this.subCategory = subCategory;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price + '\'' +
                ", category='" + category + '\'' +
                ", subCategory='" + subCategory + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Double.compare(product.getPrice(), getPrice()) == 0 &&
                Objects.equals(getName(), product.getName()) &&
                Objects.equals(getCategory(), product.getCategory()) &&
                Objects.equals(getSubCategory(), product.getSubCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice(), getCategory(), getSubCategory());
    }
}
