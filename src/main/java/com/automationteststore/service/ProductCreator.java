package com.automationteststore.service;

import com.automationteststore.model.Product;

public class ProductCreator {
    public static final String PRODUCT_NAME = "ALLEGIANT BY VERONICA ROTH";
    public static final double PRODUCT_PRICE = 7.99;
    public static final String PRODUCT_CATEGORY = "BOOKS";
    public static final String PRODUCT_SUBCATEGORY = "Paperback";

    public static Product createProduct() {
        return new Product(PRODUCT_NAME, PRODUCT_PRICE, PRODUCT_CATEGORY, PRODUCT_SUBCATEGORY);
    }
}
