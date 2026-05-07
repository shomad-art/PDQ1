import java.util.Scanner;

public class latihaUts {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // DEKLARASI ARRAY 1D DENGAN BATAS MAKSIMAL (karena tidak boleh ArrayList)
        int MAX_DATA = 100;
        String[] kategori = new String[MAX_DATA];
        int[] harga = new int[MAX_DATA];
        int[] kuota = new int[MAX_DATA];
        int[] terjual = new int[MAX_DATA]; // Menyimpan jumlah tiket yang laku
        
        int jumlahData = 0; // Melacak seberapa banyak array yang sudah terisi
        int pilihan;

        do {
            System.out.println("\n==============================================");
            System.out.println("   SISTEM MANAJEMEN TIKET SURABAYAZOO (PRO)   ");
            System.out.println("==============================================");
            System.out.println("1. Input Data Kategori Tiket");
            System.out.println("2. Pemesanan Tiket Pengunjung");
            System.out.println("3. Laporan Transaksi & Analisis");
            System.out.println("4. Edit / Hapus Kategori");
            System.out.println("5. [Dewa] Cari Kategori (Linear Search)");
            System.out.println("6. [Dewa] Sorting Peringkat Penjualan");
            System.out.println("7. [Dewa] Reset Data Harian");
            System.out.println("8. Keluar Program");
            System.out.print("Pilih menu (1-8): ");
            pilihan = scanner.nextInt();
            scanner.nextLine(); // Mencegah bug buffer setelah input angka

            switch (pilihan) {
                case 1:
                    System.out.println("\n--- 1. INPUT DATA TIKET ---");
                    System.out.print("Berapa kategori yang ingin ditambahkan? : ");
                    int tambah = scanner.nextInt();
                    scanner.nextLine();

                    for (int i = 0; i < tambah; i++) {
                        int indexSekarang = jumlahData;
                        
                        // Validasi String tidak boleh kosong
                        String inputKategori = "";
                        while (inputKategori.trim().isEmpty()) {
                            System.out.print("\nNama Kategori ke-" + (i + 1) + " (Anak/Dewasa/VIP): ");
                            inputKategori = scanner.nextLine();
                            if (inputKategori.trim().isEmpty()) System.out.println("Kategori tidak boleh kosong!");
                        }
                        kategori[indexSekarang] = inputKategori;

                        // Validasi Harga tidak boleh negatif
                        int inputHarga = -1;
                        while (inputHarga < 0) {
                            System.out.print("Harga Tiket " + inputKategori + " : Rp ");
                            inputHarga = scanner.nextInt();
                            if (inputHarga < 0) System.out.println("Harga tidak boleh negatif!");
                        }
                        harga[indexSekarang] = inputHarga;

                        // Validasi Kuota tidak boleh negatif
                        int inputKuota = -1;
                        while (inputKuota < 0) {
                            System.out.print("Kuota Maksimal per Hari : ");
                            inputKuota = scanner.nextInt();
                            if (inputKuota < 0) System.out.println("Kuota tidak boleh negatif!");
                        }
                        kuota[indexSekarang] = inputKuota;
                        terjual[indexSekarang] = 0; // Default awal terjual adalah 0

                        jumlahData++; // Menambah jumlah data yang aktif
                    }
                    System.out.println("Data berhasil disimpan!");
                    break;

                case 2:
                    System.out.println("\n--- 2. PEMESANAN TIKET ---");
                    if (jumlahData == 0) {
                        System.out.println("Belum ada data tiket! Isi menu 1 dahulu.");
                        break;
                    }

                    // Menampilkan opsi
                    for (int i = 0; i < jumlahData; i++) {
                        System.out.println((i + 1) + ". " + kategori[i] + " - Rp " + harga[i] + " (Sisa Kuota: " + kuota[i] + ")");
                    }
                    
                    System.out.print("Pilih nomor kategori tiket yang dibeli (1-" + jumlahData + "): ");
                    int pilihanBeli = scanner.nextInt() - 1;

                    if (pilihanBeli >= 0 && pilihanBeli < jumlahData) {
                        System.out.print("Jumlah tiket yang dibeli: ");
                        int beli = scanner.nextInt();

                        if (beli <= 0) {
                            System.out.println("Jumlah beli harus lebih dari 0!");
                        } else if (beli > kuota[pilihanBeli]) {
                            System.out.println("Kuota tidak mencukupi! Sisa kuota hanya " + kuota[pilihanBeli]);
                        } else {
                            // Hitung biaya dan diskon
                            double totalHarga = harga[pilihanBeli] * beli;
                            System.out.println("\nSubtotal awal: Rp " + totalHarga);

                            if (beli > 5) {
                                System.out.println("🎉 Dapat Diskon 10% (Beli > 5 tiket)!");
                                totalHarga *= 0.90;
                            }
                            if (totalHarga > 200000) {
                                System.out.println("🎉 Dapat Tambahan Diskon 5% (Total Harga > 200.000)!");
                                totalHarga *= 0.95;
                            }

                            System.out.println("---------------------------------");
                            System.out.println("TOTAL BAYAR AKHIR: Rp " + (long)totalHarga);

                            // Mengurangi kuota dan menambah catatan penjualan
                            kuota[pilihanBeli] -= beli;
                            terjual[pilihanBeli] += beli;
                            System.out.println("Tiket berhasil dipesan!");
                        }
                    } else {
                        System.out.println("Nomor tiket tidak valid!");
                    }
                    break;

                case 3:
                    System.out.println("\n--- 3. LAPORAN & ANALISIS TRANSAKSI ---");
                    if (jumlahData == 0) {
                        System.out.println("Data masih kosong!");
                        break;
                    }

                    int totalTiketTerjual = 0;
                    long totalPendapatan = 0;
                    int maxLaku = -1, minLaku = 999999;
                    String namaMax = "", namaMin = "";

                    System.out.println("Data Kategori Tiket:");
                    for (int i = 0; i < jumlahData; i++) {
                        int totalKuotaAwal = kuota[i] + terjual[i];
                        double persentase = (double) terjual[i] / totalKuotaAwal * 100;
                        
                        System.out.println("- " + kategori[i] + " | Harga: Rp" + harga[i] + " | Sisa: " + kuota[i] + " | Terjual: " + terjual[i] + " (" + String.format("%.1f", persentase) + "%)");
                        
                        if (kuota[i] < 3) {
                            System.out.println("  ⚠️ STOK HAMPIR HABIS!");
                        }

                        totalTiketTerjual += terjual[i];
                        totalPendapatan += (long) terjual[i] * harga[i]; // Pendapatan kotor sebelum diskon

                        // Mencari Max dan Min
                        if (terjual[i] > maxLaku) {
                            maxLaku = terjual[i];
                            namaMax = kategori[i];
                        }
                        if (terjual[i] < minLaku) {
                            minLaku = terjual[i];
                            namaMin = kategori[i];
                        }
                    }

                    System.out.println("\nAnalisis Penjualan:");
                    System.out.println("Total Pendapatan (Kotor): Rp " + totalPendapatan);
                    System.out.println("Total Tiket Terjual Keseluruhan: " + totalTiketTerjual);
                    System.out.println("Rata-rata Penjualan per Kategori: " + (double)totalTiketTerjual / jumlahData);
                    System.out.println("Kategori Paling Laris: " + namaMax + " (" + maxLaku + " tiket)");
                    System.out.println("Kategori Paling Sepi: " + namaMin + " (" + minLaku + " tiket)");
                    break;

                case 4:
                    System.out.println("\n--- 4. EDIT / HAPUS KATEGORI ---");
                    for (int i = 0; i < jumlahData; i++) {
                        System.out.println((i + 1) + ". " + kategori[i] + " - Rp " + harga[i]);
                    }
                    System.out.print("Pilih nomor kategori: ");
                    int idx = scanner.nextInt() - 1;

                    if (idx >= 0 && idx < jumlahData) {
                        System.out.println("1. Edit Harga");
                        System.out.println("2. Hapus Kategori");
                        System.out.print("Pilihan: ");
                        int opsi = scanner.nextInt();

                        if (opsi == 1) {
                            System.out.print("Masukkan harga baru: Rp ");
                            int hargaBaru = scanner.nextInt();
                            if (hargaBaru >= 0) {
                                harga[idx] = hargaBaru;
                                System.out.println("Harga diperbarui!");
                            } else {
                                System.out.println("Harga tidak boleh negatif.");
                            }
                        } else if (opsi == 2) {
                            // PROSES MENGGESER ARRAY (Menghapus tanpa ArrayList)
                            for (int j = idx; j < jumlahData - 1; j++) {
                                kategori[j] = kategori[j + 1];
                                harga[j] = harga[j + 1];
                                kuota[j] = kuota[j + 1];
                                terjual[j] = terjual[j + 1];
                            }
                            jumlahData--; // Data aktif berkurang 1
                            System.out.println("Kategori berhasil dihapus dan array dirapikan!");
                        }
                    } else {
                        System.out.println("Pilihan tidak valid!");
                    }
                    break;

                case 5:
                    System.out.println("\n--- 5. CARI KATEGORI TIKET ---");
                    System.out.print("Masukkan nama kategori yang dicari: ");
                    String cari = scanner.nextLine();
                    boolean ketemu = false;
                    
                    for (int i = 0; i < jumlahData; i++) {
                        if (kategori[i].equalsIgnoreCase(cari)) {
                            System.out.println("Ditemukan: " + kategori[i] + " | Harga: Rp" + harga[i] + " | Sisa Kuota: " + kuota[i]);
                            ketemu = true;
                            break;
                        }
                    }
                    if (!ketemu) System.out.println("Kategori '" + cari + "' tidak ditemukan.");
                    break;

                case 6:
                    System.out.println("\n--- 6. SORTING PERINGKAT PENJUALAN ---");
                    // Bubble Sort manual untuk paralel array (Descending / Terbanyak)
                    for (int i = 0; i < jumlahData - 1; i++) {
                        for (int j = 0; j < jumlahData - i - 1; j++) {
                            if (terjual[j] < terjual[j + 1]) {
                                // Swap terjual
                                int tempT = terjual[j]; terjual[j] = terjual[j + 1]; terjual[j + 1] = tempT;
                                // Swap kategori
                                String tempK = kategori[j]; kategori[j] = kategori[j + 1]; kategori[j + 1] = tempK;
                                // Swap harga
                                int tempH = harga[j]; harga[j] = harga[j + 1]; harga[j + 1] = tempH;
                                // Swap kuota
                                int tempQ = kuota[j]; kuota[j] = kuota[j + 1]; kuota[j + 1] = tempQ;
                            }
                        }
                    }
                    System.out.println("Array berhasil diurutkan berdasarkan penjualan terbanyak!");
                    for (int i = 0; i < jumlahData; i++) {
                        System.out.println((i + 1) + ". " + kategori[i] + " (Terjual: " + terjual[i] + " tiket)");
                    }
                    break;

                case 7:
                    System.out.println("\n--- 7. RESET DATA HARIAN ---");
                    for (int i = 0; i < jumlahData; i++) {
                        kuota[i] += terjual[i]; // Mengembalikan stok yang terjual menjadi kuota utuh
                        terjual[i] = 0; // Mengosongkan catatan terjual
                    }
                    System.out.println("Sistem telah direset ke awal hari. Semua tiket yang terjual dikembalikan ke kuota.");
                    break;

                case 8:
                    System.out.println("\nTerima kasih telah menggunakan sistem SurabayaZoo!");
                    break;

                default:
                    System.out.println("Pilihan menu tidak valid!");
            }
        } while (pilihan != 8);

        scanner.close(); // Diletakkan PALING AKHIR sesuai pengalaman error-mu sebelumnya
    }
}