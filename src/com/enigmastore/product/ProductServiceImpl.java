package com.enigmastore.product;

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
                    if (nameProduct.length()<3||nameProduct.length()>50){
                        System.out.println("Minimal 3 Karakter, dan maksimal 50 karakter.");
                    }
                    brand=Helper.updateString("Brand (min 3 karakter, maks 30 karakter)");
                    if (brand.length()<3||brand.length()>30){
                        System.out.println("Minimal 3 karakter, dan maksimal 30 karakter.");
                    }
                    price=Helper.updateInteger("Harga (harus angka positif)");
                    if (price<0){
                        System.out.println("Harga harus angka positif.");
                    }
                    String stringPrice=price.toString();
                    if (nameProduct.isEmpty()||nameProduct.isBlank()||brand.isEmpty()||brand.isBlank()||stringPrice.isEmpty()||stringPrice.isBlank()){
                        System.out.println("Produk gagal diperbarui");
                        return ;
                    }else {
                        product1.setNameProduct(nameProduct);
                        product1.setBrand(brand);
                        product1.setPrice(price);
                    }
                }while (nameProduct.length()<3 || nameProduct.length()>50 || brand.length()<3 || brand.length()>30 || price<0);

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
