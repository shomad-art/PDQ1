//1. Import Scanner
import java.util.Scanner;
public class latihanScannner {
    public static void main(String[] args) {
        //2. Deklarasi Scanner
        Scanner Scanner = new Scanner(System.in);

        //3. input (Deklarasi Variabel)
        // Value dalam variabel harus digunakan nilai default
        String namaBarang = "";
        int harga = 0, jumlahBeli = 0, totalHarga = 0;

        //teks input
        System.out.print("Masukkan Nama Barang Anda : ");
        namaBarang = Scanner.nextLine(); //nextLine untuk String
        System.out.print("Harga Barang : ");
        harga = Scanner.nextInt(); //nextInt untuk Integer
        System.out.print("Jumlah Beli : ");
        jumlahBeli = Scanner.nextInt(); 
        System.out.println(); //untuk buat jarak baris baru kosong

        //4. Output
        totalHarga = harga * jumlahBeli;
        System.out.println("Nama Barang \t: " + namaBarang);
        System.out.println("Jumlah Beli \t: " + jumlahBeli);
        System.out.println("Harga Barang \t: " + harga);
        System.out.println("Total Harga \t: " + totalHarga);
        
        //5. Close Scanner
        Scanner.close(); 
    }
}
