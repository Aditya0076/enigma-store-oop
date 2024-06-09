package com.enigmastore.checker;

public class Checker {
    public static void checkNameProduct(String nameProduct) throws Exception {
        if (nameProduct.length()<3 || nameProduct.length()>50){
            throw new Exception("Data harus huruf minimal 3 Karakter, dan maksimal 50 karakter.");
        }
    }
    public static void checkBrand(String brand) throws Exception {
        if (brand.length()<3 || brand.length()>30){
            throw new Exception("Data harus huruf minimal 3 Karakter, dan maksimal 30 karakter.");
        }
    }
    public static void checkPrice(Integer price) throws Exception {
        if (price<0){
            throw new Exception("Harga harus angka positif.");
        }
    }
    public static void checkDataProduct(String nameProduct, String brand, Integer price){
        String stringPrice=price.toString();
        if (nameProduct.isEmpty()||nameProduct.isBlank()||brand.isEmpty()||brand.isBlank()||stringPrice.isEmpty()||stringPrice.isBlank()){
            System.out.println("Produk gagal diperbarui");
            return ;
        }
    }
}
