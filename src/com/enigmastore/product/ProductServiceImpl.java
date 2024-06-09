package com.enigmastore.product;

import com.enigmastore.checker.Checker;
import com.enigmastore.helper.Helper;
import com.enigmastore.service.ProductService;

import java.util.*;


public class ProductServiceImpl implements ProductService {
    List<Product> products =new ArrayList<>();

    Integer productIndex=0;
    @Override
    public void createProduct(Product product) {
        products.add(product);
//        productIndex++;
        System.out.println("Sukses memasukkan produk");
    }

    @Override
    public void viewProduct() {
        productIndex=1;
        Date date = new Date();
        if (products.size()==0){
            System.out.println("Tidak ada produk yang ditampilkan");
            return;
        }
        System.out.println("-".repeat(100));
        System.out.println("|"+" ".repeat(5)+"No"+" ".repeat(5)+"|"+" ".repeat(5)+"Product"+" ".repeat(5)+"|"+" ".repeat(5)+"Brand"+" ".repeat(5)+"|"+" ".repeat(5)+"Price"+" ".repeat(5)+"|"+" ".repeat(5)+ "Tanggal Pembelian "+" ".repeat(5)+"|");
        System.out.println("-".repeat(100));
        for (Product product : products) {
            System.out.println("|"+" ".repeat(5)+(productIndex++)+" ".repeat(5)+"|"+" ".repeat(5)+product.getNameProduct()+" ".repeat(5)+"|"+" ".repeat(5)+product.getBrand()+" ".repeat(5)+"|"+" ".repeat(5)+product.getPrice()+" ".repeat(5)+"|"+" ".repeat(5)+ date +" ".repeat(5)+"|");
            System.out.println("-".repeat(100));
        }

    }

    @Override
    public void updateProduct(Product product, Integer productId) {
        Iterator<Product> iterator = products.iterator();
        String nameProduct="";
        String brand="";
        Integer price=0;
        productIndex=0;
        while (iterator.hasNext()){
            Product product1=iterator.next();
            if (Objects.equals(productIndex+1, productId)){
                do {
                    nameProduct=Helper.updateString("Nama produk (min 3 karakter, maks 50 karakter)");
                    try {
                        Checker.checkNameProduct(nameProduct);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }while (nameProduct.length()<3 || nameProduct.length()>50);
                do {
                    brand=Helper.updateString("Brand (min 3 karakter, maks 30 karakter)");
                    try {
                        Checker.checkBrand(brand);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }while (brand.length()<3 || brand.length()>30);
                do {
                    price=Helper.updateInteger("Harga (harus angka positif)");
                    try {
                        Checker.checkPrice(price);
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                }while (price<0);

                product1.setNameProduct(nameProduct);
                product1.setBrand(brand);
                product1.setPrice(price);
                System.out.println("Produk berhasil diperbarui");
                return;
            }
            productIndex++;
        }
        System.out.println("Produk tidak ditemukan");
    }

    @Override
    public void deleteProduct(Integer productId) {
        Iterator <Product> iterator = products.iterator();
        productIndex=0;
        while (iterator.hasNext()){
            Product product=iterator.next();
            if (Objects.equals(productIndex+1, productId)){
                iterator.remove();
                System.out.println("Produk berhasil di hapus");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan");

    }


    public void searchProduct(String nameProduct){
        productIndex=0;
        for (Product product : products) {
            if (product.getNameProduct().toLowerCase().contains(nameProduct.toLowerCase())){
                System.out.println((productIndex+1)+". Daftar List Product");
                System.out.println("Nama produk: "+ product.getNameProduct());
                System.out.println("Brand produk: "+product.getBrand());
                System.out.println("Harga produk: "+product.getPrice());
                productIndex++;
            }
        }
        if (productIndex==0){
            System.out.println("Produk tidak ditemukan");
        }
    }
}
