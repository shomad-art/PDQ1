import java.util.Scanner;
public class latihanNestLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // variabel
        int jumlahTransaksi = 0;
        double transaksi = 0.0, totalPendapatan = 0.0;

        // input jumlah transaksi per hari
        System.out.print("Masukkan jumlah transaksi yang terjadi hari ini: ");
        jumlahTransaksi = sc.nextInt();

        // input transaksi per hari
        for (int i = 0; i < jumlahTransaksi; i++) {
            System.out.print("Masukkan transaksi ke-" + (i + 1) + ": ");
            transaksi = sc.nextDouble();
            totalPendapatan += transaksi;
            }
            

            // tampilkan total pendapatan
            System.out.println("Total pendapatan hari ini: " + "Rp. " + totalPendapatan);
        
        
        sc.close();
        }


        
        
    }

