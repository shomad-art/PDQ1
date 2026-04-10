import java.util.Scanner;

public class latihanPengulangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int hargaBarang = 0;
        int totalBelanja = 0;
        int barangke = 1;

        System.out.println("===PROGRAM MENGHITUNG TOTAL BELANJA ===");
        System.out.println("Ketik 0 atau angka minus jika belanjaan sudah selesai.\n");

        try {
        while (hargaBarang >= 0) {
            totalBelanja += hargaBarang;
            System.out.print("Masukkan harga barang ke-" + barangke + ": Rp ");
            hargaBarang = scanner.nextInt();
            barangke++;
        }  

            System.out.println("\n------------------------------------" );
            System.out.println("Total yang harus dibayar: Rp " + totalBelanja);


            
        } catch (Exception e) {
            System.out.println("Maaf, isian harus berupa angka!");
        }

        scanner.close();
    }
    
}
