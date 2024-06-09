package com.enigmastore;

import com.enigmastore.checker.Checker;
import com.enigmastore.helper.Helper;
import com.enigmastore.product.Product;
import com.enigmastore.product.ProductServiceImpl;

import java.util.List;


public class Menu  {
    ProductServiceImpl productService = new ProductServiceImpl();
    private String nameProduct;
    private String brand;
    private Integer price;

    public void menuStart() {
        Integer choice = 0;
        try {
            do {
             menu(choice);
            } while (choice != 6);
        }catch (Exception e){
            System.out.println("Harus angka");
        }
    }
    public void menu(Integer choice) {
        System.out.println("-".repeat(40));
        System.out.println("Main Menu");
        System.out.println("-".repeat(40));
        System.out.println("1. Tambah Produk");
        System.out.println("2. Ubah Produk");
        System.out.println("3. Hapus Produk");
        System.out.println("4. Lihat Semua Produk");
        System.out.println("5. Cari Produk Berdasarkan");
        System.out.println("6. Keluar");
        choice=Helper.inputInteger("Masukkan pilihan menu (1-6)");
        switch (choice) {
            case 1:
                addProduct();
                break;
            case 2:
                updateProduct(Integer.parseInt(Helper.inputString("Masukkan ID produk yang ingin di update")));
                break;
            case 3:
                deleteProduct(Integer.parseInt(Helper.inputString("Masukkan ID produk yang ingin di hapus")));
                break;
            case 4:
                viewProduct();
                break;
            case 5:
                searchProduct(String.valueOf(Helper.inputString("Masukkan Nama produk yang ingin dicari")));
                break;
            case 6:
                System.out.println("Terima Kasih");
                break;
            default:
                System.out.println("Pilihan menu tidak valid silahkan baca kembali");
                choice--;

        }
    }

    public void addProduct() {
        try {
                nameProduct=Helper.inputString("Nama produk (min 3 karakter, maks 50 karakter)");
                try {
                    Checker.checkNameProduct(nameProduct);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                brand=Helper.inputString("Brand Minimal (3 karakter, dan maksimal 30 karakter)");
                try {
                    Checker.checkBrand(brand);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                price=Helper.inputInteger("Harga (Harga harus angka positif)");
                try {
                    Checker.checkPrice(price);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                Checker.checkDataProduct(nameProduct, brand, price);
                productService.createProduct(new Product(nameProduct, brand, price));
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    public void viewProduct() {
        productService.viewProduct();
    }
    public void updateProduct(Integer productId) {
        productService.updateProduct(new Product(nameProduct, brand, price), productId);
    }
    public void deleteProduct(Integer productId) {
        productService.deleteProduct(productId);
    }
    public void searchProduct(String productName) {
        productService.searchProduct(productName);
    }
}
