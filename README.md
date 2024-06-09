EnigmaStore

EnigmaStore adalah sebuah aplikasi sederhana untuk mengelola produk. Aplikasi ini mencakup fitur untuk menambah, memperbarui, menghapus, melihat, dan mencari produk.
Struktur Proyek

    com.enigmastore
        Menu.java
    com.enigmastore.checker
        Checker.java
    com.enigmastore.helper
        Helper.java
    com.enigmastore.product
        Product.java
        ProductServiceImpl.java
    com.enigmastore.service
        ProductService.java

Penjelasan Kelas
1. Menu.java

Kelas Menu menyediakan antarmuka utama untuk pengguna untuk berinteraksi dengan aplikasi. Fitur yang disediakan meliputi:

    menuStart(): Memulai menu utama dan menangani input pengguna.
    menu(Integer choice): Menampilkan menu utama dan menangani pilihan pengguna.
    addProduct(): Menambahkan produk baru dengan validasi.
    updateProduct(Integer productId): Memperbarui informasi produk berdasarkan ID.
    deleteProduct(Integer productId): Menghapus produk berdasarkan ID.
    viewProduct(): Menampilkan semua produk.
    searchProduct(String productName): Mencari produk berdasarkan nama.

2. Product.java

Kelas Product merepresentasikan entitas produk dengan atribut:

    nameProduct: Nama produk.
    brand: Merek produk.
    price: Harga produk.

3. ProductService.java

Antarmuka ProductService mendefinisikan operasi dasar yang dapat dilakukan pada produk:

    createProduct(Product product): Menambahkan produk baru.
    updateProduct(Product product, Integer productId): Memperbarui produk berdasarkan ID.
    deleteProduct(Integer productId): Menghapus produk berdasarkan ID.
    viewProduct(): Menampilkan semua produk.
    searchProduct(String nameProduct): Mencari produk berdasarkan nama.

4. ProductServiceImpl.java

Kelas ProductServiceImpl mengimplementasikan antarmuka ProductService dan menyediakan logika bisnis untuk operasi produk:

    createProduct(Product product): Menambahkan produk baru ke daftar.
    viewProduct(): Menampilkan semua produk.
    updateProduct(Product product, Integer productId): Memperbarui produk berdasarkan ID.
    deleteProduct(Integer productId): Menghapus produk berdasarkan ID.
    searchProduct(String nameProduct): Mencari produk berdasarkan nama.

5. Checker.java

Kelas Checker menyediakan metode validasi untuk atribut produk:

    checkNameProduct(String nameProduct): Memvalidasi panjang nama produk.
    checkBrand(String brand): Memvalidasi panjang brand.
    checkPrice(Integer price): Memvalidasi harga agar positif.
    checkDataProduct(String nameProduct, String brand, Integer price): Memeriksa bahwa tidak ada atribut yang kosong.

6. Helper.java

Kelas Helper menyediakan metode utilitas untuk membaca input dari pengguna melalui konsol:

    inputString(String string): Membaca input string dari pengguna.
    inputInteger(String integer): Membaca input integer dari pengguna.
    updateString(String string): Membaca input string untuk pembaruan.
    updateInteger(String integer): Membaca input integer untuk pembaruan.

Cara Menggunakan

    Jalankan kelas Menu.
    Ikuti petunjuk di konsol untuk menambah, memperbarui, menghapus, melihat, dan mencari produk.

Contoh


```
public static void main(String[] args) {
Menu menu = new Menu();
menu.menuStart();
}
```

Catatan

    Pastikan untuk menangani input dengan benar untuk menghindari kesalahan runtime.
    Validasi dilakukan menggunakan kelas Checker.