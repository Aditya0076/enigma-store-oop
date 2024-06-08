package com.enigmastore.product;

public class Product {
    private String nameProduct;
    private String brand;
    private Integer price;

    public Product(String nameProduct, String brand, Integer price) {
        this.nameProduct = nameProduct;
        this.brand = brand;
        this.price = price;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
            this.nameProduct = nameProduct;

    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }


}
