package com.paves.pavesvet.model;

public class Product {
    public String product_title;

    public Product() {
    }

    public Product(String product_title) {
        this.product_title = product_title;
    }

    public String getProduct_title() {
        return product_title;
    }

    public void setProduct_title(String product_title) {
        this.product_title = product_title;
    }
}
