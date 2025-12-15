import java.util.Scanner;

public class tubeselektronik {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Maksimal 100 produk
        String[] nama = new String[100];
        int[] stok = new int[100];
        double[] harga = new double[100];
        int jumlahProduk = 0;

        boolean jalan = true;

        while (jalan) {
            System.out.println("\n=== MENU INVENTARIS ===");
            System.out.println("1. Tambah Produk");
            System.out.println("2. Lihat Semua Produk");
            System.out.println("3. Update Stok Produk");
            System.out.println("4. Hapus Produk");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");

            int menu = sc.nextInt();
            sc.nextLine(); // buang newline

            switch (menu) {

                // TAMBAH PRODUK
                case 1:
                    System.out.print("Nama produk: ");
                    nama[jumlahProduk] = sc.nextLine();

                    System.out.print("Harga produk: ");
                    harga[jumlahProduk] = sc.nextDouble();

                    System.out.print("Stok produk: ");
                    stok[jumlahProduk] = sc.nextInt();
                    sc.nextLine();

                    jumlahProduk++;
                    System.out.println("Produk berhasil ditambahkan!");
                    break;

                // LIHAT SEMUA PRODUK
                case 2:
                    System.out.println("\n=== DAFTAR PRODUK ===");
                    for (int i = 0; i < jumlahProduk; i++) {
                        System.out.println(
                            (i + 1) + ". " + nama[i] +
                            " | Harga: " + harga[i] +
                            " | Stok: " + stok[i]
                        );
                    }
                    break;

                // UPDATE STOK
                case 3:
                    System.out.print("Masukkan nomor produk: ");
                    int idxUpdate = sc.nextInt() - 1;

                    if (idxUpdate >= 0 && idxUpdate < jumlahProduk) {
                        System.out.print("Stok baru: ");
                        stok[idxUpdate] = sc.nextInt();
                        System.out.println("Stok diperbarui!");
                    } else {
                        System.out.println("Nomor produk tidak valid.");
                    }
                    break;

                // HAPUS PRODUK
                case 4:
                    System.out.print("Masukkan nomor produk: ");
                    int idxHapus = sc.nextInt() - 1;

                    if (idxHapus >= 0 && idxHapus < jumlahProduk) {
                        for (int i = idxHapus; i < jumlahProduk - 1; i++) {
                            nama[i] = nama[i + 1];
                            harga[i] = harga[i + 1];
                            stok[i] = stok[i + 1];
                        }
                        jumlahProduk--;
                        System.out.println("Produk dihapus!");
                    } else {
                        System.out.println("Nomor produk tidak valid.");
                    }
                    break;

                // KELUAR
                case 5:
                    jalan = false;
                    System.out.println("Keluar program...");
                    break;

                default:
                    System.out.println("Menu tidak tersedia.");
            }
        }

        sc.close();
    }
}
