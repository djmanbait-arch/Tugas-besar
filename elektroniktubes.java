import java.util.Scanner;

public class elektroniktubes {

    // Array data produk
    static String[] nama = new String[100];
    static int[] stok = new int[100];
    static double[] harga = new double[100];
    static int jumlahProduk = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean jalan = true;

        while (jalan) {
            tampilMenu();
            System.out.print("Pilih Menu: ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    tambahProduk(sc);
                    break;

                case 2:
                    tampilkanTabelProduk();
                    break;

                case 3:
                    updateStok(sc);
                    break;

                case 4:
                    hapusProduk(sc);
                    break;

                case 5:
                    jalan = false;
                    System.out.println("Keluar program...");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }
    }

    // ===========================
    // FUNCTION MENU
    // ===========================
    public static void tampilMenu() {
        System.out.println("\n===== MENU INVENTARIS =====");
        System.out.println("1. Tambah produk");
        System.out.println("2. Lihat semua produk");
        System.out.println("3. Update stok produk");
        System.out.println("4. Hapus produk");
        System.out.println("5. Keluar");
    }

    // ===========================
    // FUNCTION TAMBAH PRODUK
    // ===========================
    public static void tambahProduk(Scanner sc) {
        System.out.print("Nama produk: ");
        nama[jumlahProduk] = sc.nextLine();

        System.out.print("Harga produk: ");
        harga[jumlahProduk] = sc.nextDouble();

        System.out.print("Stok produk: ");
        stok[jumlahProduk] = sc.nextInt();
        sc.nextLine();

        jumlahProduk++;
        System.out.println("Produk berhasil ditambahkan!");
    }

    // ===========================
    // FUNCTION TAMPILKAN TABEL
    // ===========================
    public static void tampilkanTabelProduk() {
        if (jumlahProduk == 0) {
            System.out.println("\nBelum ada produk!");
            return;
        }

        System.out.println("\n================= DAFTAR PRODUK ======================");
        System.out.println("+----+----------------------+---------------+--------+");
        System.out.println("| No | Nama Produk          | Harga         | Stok   |");
        System.out.println("+----+----------------------+---------------+--------+");

        for (int i = 0; i < jumlahProduk; i++) {
            System.out.printf("| %-2d | %-20s | %-13.2f | %-6d |\n",
                    (i + 1), nama[i], harga[i], stok[i]);
        }

        System.out.println("+----+----------------------+---------------+--------+");
    }

    // ===========================
    // FUNCTION UPDATE STOK
    // ===========================
    public static void updateStok(Scanner sc) {
        tampilkanTabelProduk();

        System.out.print("Masukkan nomor produk: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < jumlahProduk) {
            System.out.print("Stok baru: ");
            stok[index] = sc.nextInt();
            System.out.println("Stok berhasil diperbarui!");
        } else {
            System.out.println("Nomor produk tidak valid!");
        }
    }

    // ===========================
    // FUNCTION HAPUS PRODUK
    // ===========================
    public static void hapusProduk(Scanner sc) {
        tampilkanTabelProduk();

        System.out.print("Masukkan nomor produk: ");
        int hapus = sc.nextInt() - 1;

        if (hapus >= 0 && hapus < jumlahProduk) {
            for (int i = hapus; i < jumlahProduk - 1; i++) {
                nama[i] = nama[i + 1];
                harga[i] = harga[i + 1];
                stok[i] = stok[i + 1];
            }
            jumlahProduk--;
            System.out.println("Produk berhasil dihapus!");
        } else {
            System.out.println("Nomor produk tidak valid!");
        }
    }
}