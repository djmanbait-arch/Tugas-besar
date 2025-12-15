import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenInventarisApple {
    static ArrayList<ProdukApple> daftarProduk = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("\n=== SISTEM INVENTARIS PRODUK APPLE ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Tampilkan Produk");
            System.out.println("3. Cari Produk");
            System.out.println("4. Edit Produk");
            System.out.println("5. Hapus Produk");
            System.out.println("6. Transaksi (Kurangi Stok)");
            System.out.println("0. Keluar");
            System.out.print("Pilih: ");
            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1 -> tambahProduk();
                case 2 -> tampilProduk();
                case 3 -> cariProduk();
                case 4 -> editProduk();
                case 5 -> hapusProduk();
                case 6 -> transaksi();
            }
        } while (pilihan != 0);
    }

    static void tambahProduk() {
        System.out.print("Nama Produk: ");
        String nama = input.nextLine();
        System.out.print("Kategori: ");
        String kategori = input.nextLine();
        System.out.print("Harga: ");
        double harga = input.nextDouble();
        System.out.print("Stok: ");
        int stok = input.nextInt();

        daftarProduk.add(new ProdukApple(nama, kategori, harga, stok));
        System.out.println("Produk berhasil ditambahkan.");
    }

    static void tampilProduk() {
        if (daftarProduk.isEmpty()) {
            System.out.println("Data produk kosong.");
            return;
        }
        for (ProdukApple p : daftarProduk) {
            p.tampil();
        }
    }

    static void cariProduk() {
        System.out.print("Nama produk: ");
        String cari = input.nextLine();
        for (ProdukApple p : daftarProduk) {
            if (p.nama.equalsIgnoreCase(cari)) {
                p.tampil();
                return;
            }
        }
        System.out.println("Produk tidak ditemukan.");
    }

    static void editProduk() {
        System.out.print("Nama produk: ");
        String cari = input.nextLine();
        for (ProdukApple p : daftarProduk) {
            if (p.nama.equalsIgnoreCase(cari)) {
                System.out.print("Harga baru: ");
                p.harga = input.nextDouble();
                System.out.print("Stok baru: ");
                p.stok = input.nextInt();
                System.out.println("Data diperbarui.");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan.");
    }

    static void hapusProduk() {
        System.out.print("Nama produk: ");
        String cari = input.nextLine();
        for (ProdukApple p : daftarProduk) {
            if (p.nama.equalsIgnoreCase(cari)) {
                daftarProduk.remove(p);
                System.out.println("Produk dihapus.");
                return;
            }
        }
        System.out.println("Produk tidak ditemukan.");
    }

    static void transaksi() {
        System.out.print("Nama produk: ");
        String cari = input.nextLine();
        System.out.print("Jumlah beli: ");
        int jumlah = input.nextInt();

        for (ProdukApple p : daftarProduk) {
            if (p.nama.equalsIgnoreCase(cari)) {
                if (p.stok >= jumlah) {
                    p.stok -= jumlah;
                    System.out.println("Transaksi berhasil.");
                } else {
                    System.out.println("Stok tidak cukup.");
                }
                return;
            }
        }
        System.out.println("Produk tidak ditemukan.");
    }
}
