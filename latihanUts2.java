import java.util.Scanner;

public class latihanUts2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SIMULASI ANTRIAN WAHANA ===");
        System.out.print("Masukkan jumlah pengunjung awal di antrian: ");
        int n = scanner.nextInt();

        // Deklarasi Array 1D yang elemennya ditentukan secara dinamis [2]
        int[] antrian = new int[n];
        
        System.out.println("Masukkan nomor pengunjung secara berurutan (pisahkan dengan spasi/enter):");
        // Menggunakan loop untuk mengisi elemen array secara dinamis sesuai aturan [3]
        for (int i = 0; i < n; i++) {
            antrian[i] = scanner.nextInt();
        }

        System.out.print("Masukkan waktu simulasi (K menit): ");
        int k = scanner.nextInt();
        
        // Array paralel untuk melacak posisi baru pengunjung setelah K menit
        int[] posisiAkhir = new int[n];
        int jumlahSisa = 0;

        // 1. MENGHITUNG POSISI SETIAP ORANG SETELAH K MENIT
        for (int i = 0; i < n; i++) {
            // Menentukan kecepatan: Genap maju 2, Ganjil maju 1
            int kecepatan = (antrian[i] % 2 == 0) ? 2 : 1;
            
            // Menghitung posisi indeks baru 
            posisiAkhir[i] = i - (kecepatan * k);
            
            // Jika posisi >= 0, berarti ia masih mengantri di luar wahana
            if (posisiAkhir[i] >= 0) {
                jumlahSisa++;
            }
        }

        // 2. MENYARING PENGUNJUNG YANG MASIH BERTAHAN
        if (jumlahSisa == 0) {
            System.out.println("\nSetelah " + k + " menit, semua pengunjung sudah masuk wahana (antrian kosong)!");
        } else {
            // Membuat array baru khusus untuk pengunjung yang tersisa
            int[] antrianSisa = new int[jumlahSisa];
            int[] posisiSisa = new int[jumlahSisa];
            int indeksBaru = 0;

            for (int i = 0; i < n; i++) {
                if (posisiAkhir[i] >= 0) {
                    antrianSisa[indeksBaru] = antrian[i];
                    posisiSisa[indeksBaru] = posisiAkhir[i];
                    indeksBaru++;
                }
            }

            // 3. MENGURUTKAN ULANG ANTRIAN (Bubble Sort Manual)
            // Memastikan yang posisinya paling depan berada di indeks ke-0
            for (int i = 0; i < jumlahSisa - 1; i++) {
                for (int j = 0; j < jumlahSisa - i - 1; j++) {
                    if (posisiSisa[j] > posisiSisa[j + 1]) {
                        // Swap posisi agar berurutan
                        int tempPos = posisiSisa[j];
                        posisiSisa[j] = posisiSisa[j + 1];
                        posisiSisa[j + 1] = tempPos;

                        // Swap data nomor pengunjung paralel dengan posisinya
                        int tempAntrian = antrianSisa[j];
                        antrianSisa[j] = antrianSisa[j + 1];
                        antrianSisa[j + 1] = tempAntrian;
                    }
                }
            }

            // 4. MENAMPILKAN HASIL CETAK ARRAY [4]
            System.out.println("\nKondisi antrian pengunjung setelah " + k + " menit:");
            for (int i = 0; i < jumlahSisa; i++) {
                System.out.print(antrianSisa[i] + " ");
            }
            System.out.println();
        }
        
        scanner.close();
    }
} 
    

