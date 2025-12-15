public class ProdukApple {
    String nama;
    String kategori;
    double harga;
    int stok;

    public ProdukApple(String nama, String kategori, double harga, int stok) {
        this.nama = nama;
        this.kategori = kategori;
        this.harga = harga;
        this.stok = stok;
    }

    public void tampil() {
        System.out.println(
            nama + " | " + kategori + " | Rp" + harga + " | Stok: " + stok
        );
    }
}