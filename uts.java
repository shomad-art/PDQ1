import java.util.Scanner;

public class uts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] namaHari = null;
        int[] jmlhPemakaian = null;

        int pilihan;
        do {
            System.out.println("\n==============================================");
            System.out.println("   SISTEM PENCATATAN PEMAKAIAN PENGGUNA INTERNET PERHARI   ");
            System.out.println("==============================================");
            System.out.println("1. Input Data Pemakaian Internet");
            System.out.println("2. Tampilkan Lebih dari 15 GB (Tinggi)");
            System.out.println("3. Tampilkan Lebih dari 8 GB (Sedang)");
            System.out.println("4. Tampilkan Kurang dari 8 GB (Rendah)");
            System.out.println("5. Keluar Program");
            System.out.print("Pilih menu (1-5): ");
            pilihan = sc.nextInt();
            sc.nextLine(); 

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan jumlah hari yang ingin dicatat: ");
                    int jumlahData = sc.nextInt();
                    sc.nextLine();

                    namaHari = new String[jumlahData];
                    jmlhPemakaian = new int[jumlahData];

                    System.out.println("\n--- Input Data Harian ---");
                    for (int i = 0; i < namaHari.length; i++) {
                        System.out.print("Nama hari ke-" + (i + 1) + " : ");
                        namaHari[i] = sc.nextLine();

                        System.out.print("Jumlah pemakaian (GB) pada hari " + namaHari[i] + " : ");
                        jmlhPemakaian[i] = sc.nextInt();
                        sc.nextLine(); 
                    }
                    System.out.println("Data berhasil disimpan ke dalam sistem.");
                    break;

                case 2:
                    if (namaHari == null) {
                        System.out.println("Peringatan: Harap input data di Menu 1 terlebih dahulu!");
                    } else {
                        System.out.println("\n--- Hari dengan pemakaian TINGGI (> 15 GB) ---");
                        boolean adaData = false;
                        for (int i = 0; i < namaHari.length; i++) {
                            if (jmlhPemakaian[i] > 15) {
                                System.out.println("- Hari " + namaHari[i] + " : " + jmlhPemakaian[i] + " GB (Tinggi)");
                                adaData = true;
                            }
                        }
                        if (!adaData) {
                            System.out.println("Tidak ada data yang sesuai kriteria.");
                        }
                    }
                    break;

                case 3:
                    if (namaHari == null) {
                        System.out.println("Peringatan: Harap input data di Menu 1 terlebih dahulu!");
                    } else {
                        System.out.println("\n--- Hari dengan pemakaian SEDANG (> 8 GB hingga 15 GB) ---");
                        boolean adaData = false;
                        for (int i = 0; i < namaHari.length; i++) {
                            if (jmlhPemakaian[i] > 8 && jmlhPemakaian[i] <= 15) {
                                System.out.println("- Hari " + namaHari[i] + " : " + jmlhPemakaian[i] + " GB (Sedang)");
                                adaData = true;
                            }
                        }
                        if (!adaData) {
                            System.out.println("Tidak ada data yang sesuai kriteria.");
                        }
                    }
                    break;

                case 4:
                    if (namaHari == null) {
                        System.out.println("Peringatan: Harap input data di Menu 1 terlebih dahulu!");
                    } else {
                        System.out.println("\n--- Hari dengan pemakaian RENDAH (< 8 GB) ---");
                        boolean adaData = false;
                        for (int i = 0; i < namaHari.length; i++) {
                            if (jmlhPemakaian[i] < 8) {
                                System.out.println("- Hari " + namaHari[i] + " : " + jmlhPemakaian[i] + " GB (Rendah)");
                                adaData = true;
                            }
                        }
                        if (!adaData) {
                            System.out.println("Tidak ada data yang sesuai kriteria.");
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nTerima kasih telah menggunakan sistem pencatatan pemakaian internet.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid. Silakan masukkan angka 1 hingga 5.");
            }

        } while (pilihan != 5);

        sc.close();
    }
}