import java.util.Scanner;
public class tugasKuis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // variabel
        int jumlahPaket = 0;
        double  beratPaket = 0.0, totalBerat = 0.0;

        // input jumlah paket
        System.out.println("Masukkan jumlah paket yang akan dikirim hari ini: ");
        jumlahPaket=sc.nextInt();

        // input berat paket
        for (int i=1; i<=jumlahPaket; i++) {
            System.out.println("Masukkan berat paket yang ke-" + i + " (kg): ");
            beratPaket= sc.nextDouble();
        
        // Hitung total berat paketnya
        if (beratPaket > 0) {
                totalBerat += beratPaket; 
            } else {
                System.out.println(" Peringatan: Berat paket tidak valid dan tidak dihitung!");
            }
        }
        // Total berat paket
        System.out.println("==============================================");
        System.out.println("Rekapan harian sudah selesai");
        System.out.println("Total paket yang diproses hari ini: " + jumlahPaket + " paket");
        System.out.println("Total berat keseluruhanya: " + totalBerat + " kg");
        System.out.println("==============================================");
        
        
        sc.close();
        }
        
    }

    

