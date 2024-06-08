package com.enigmastore;

import com.enigmastore.helper.Helper;
import com.enigmastore.product.Product;
import com.enigmastore.product.ProductServiceImpl;

import java.util.List;

public class Menu {
    ProductServiceImpl productService = new ProductServiceImpl();
    private String nameProduct;
    private String brand;
    private Integer price;

    public void menuStart() {
        Integer choice = 0;
        do {
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

        } while (choice != 6);


    }

    public void addProduct() {
        do {
            nameProduct=Helper.inputString("Nama produk (min 3 karakter, maks 50 karakter)");
            if (nameProduct.length()<3 || nameProduct.length()>50){
                System.out.println("Minimal 3 Karakter, dan maksimal 50 karakter.");
            }
        }while (nameProduct.length()<3 || nameProduct.length()>50);
        do {
            brand=Helper.inputString("Brand Minimal (3 karakter, dan maksimal 30 karakter)");
            if (brand.length()<3 || brand.length()>30){
                System.out.println("Minimal 3 karakter, dan maksimal 30 karakter.");
            }
        }while (brand.length()<3 || brand.length()>30);
        do {
            price=Helper.inputInteger("Harga (Harga harus angka positif)");
            if (price<0){
                System.out.println("Harga harus angka positif.");
            }
        }while (price<0);
        productService.createProduct(new Product(nameProduct, brand, price));
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
