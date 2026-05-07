import java.util.Scanner;

public class latihanUts3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== ANALISIS PENJUALAN TOKO ===");
        System.out.print("Masukkan jumlah hari (N): ");
        int n = scanner.nextInt();

        // Deklarasi Array 1D yang ukurannya dinamis ditentukan oleh user
        int[] penjualan = new int[n];

        System.out.println("Masukkan data penjualan per hari:");
        // Menggunakan loop untuk mengisi elemen array secara dinamis [4]
        for (int i = 0; i < n; i++) {
            System.out.print("Hari ke-" + (i + 1) + ": ");
            penjualan[i] = scanner.nextInt();
        }

        // Variabel untuk melacak rekor tertinggi dan periodenya
        int maxPenjualan = penjualan[0]; // Diisi data hari pertama sebagai nilai awal
        int hariMulai = 0;
        int hariSelesai = 0;

        // LOGIKA LEVEL DEWA: Nested Loop untuk mengecek semua kombinasi hari berturut-turut
        // Loop luar (i) menentukan HARI MULAI periode
        for (int i = 0; i < penjualan.length; i++) { 
            int totalSementara = 0;
            
            // Loop dalam (j) menentukan HARI SELESAI periode
            for (int j = i; j < penjualan.length; j++) {
                totalSementara += penjualan[j]; // Menjumlahkan penjualan dari hari i sampai hari j

                // Jika total pada periode ini lebih besar dari rekor maxPenjualan saat ini, simpan datanya!
                if (totalSementara > maxPenjualan) {
                    maxPenjualan = totalSementara;
                    hariMulai = i;  // Menyimpan indeks hari mulai
                    hariSelesai = j; // Menyimpan indeks hari selesai
                }
            }
        }

        // MENCETAK HASIL
        System.out.println("\n==============================================");
        System.out.println("LAPORAN ANALISIS PENJUALAN TERBAIK");
        System.out.println("==============================================");
        System.out.println("Total Penjualan Terbesar : " + maxPenjualan);
        
        // Ditambah 1 karena indeks array selalu dimulai dari 0 [1]
        if (hariMulai == hariSelesai) {
            System.out.println("Dicapai pada             : Hanya Hari ke-" + (hariMulai + 1));
        } else {
            System.out.println("Dicapai pada periode     : Hari ke-" + (hariMulai + 1) + " sampai Hari ke-" + (hariSelesai + 1));
        }
        System.out.println("==============================================");

        scanner.close();
    }
}