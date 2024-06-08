package com.enigmastore.service;

import com.enigmastore.product.Product;

import java.util.List;

public interface ProductService {
    void createProduct(Product product);
    void updateProduct(Product product, Integer productId);
    void deleteProduct(Integer productId);
    void viewProduct();
    void searchProduct(String nameProduct);

}
