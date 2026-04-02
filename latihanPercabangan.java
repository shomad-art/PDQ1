// STUDI KASUS
//Inimaret adalah sebuah usaha retail yang menjual berbagai kebutuhan pokok. Selain harganya yang lebih terjangkau, Inimaret juga menawarkan berbagai keuntungan diskon melalui batas nominal belanja dan membership. Jika pelanggan mendaftarkan membership, maka pelanggan cukup mengisi identitas umum, seperti nama, alamat, dan nomor hp. Keuntungan diskon berlaku bagi pelanggan member maupun non member. Beberapa ketentuannya adalah:

//Belanja > 100.000, diskon 5%
//Belanja > 300.000, diskon 10%
//Terdaftar member, diskon 2%
//Dari ketentuan di atas, Inimaret membutuhkan sebuah program sederhana untuk memasukkan data belanja pelanggan serta menghitung total sekaligus diskon yang diterima. Program tersebut harus memiliki fitur untuk input bebas melalui keyboard dan memiliki struktur percabangan yang sesuai.


//ANALISIS STUDI KASUS
//Berdasarkan studi kasus di atas, lakukan:
//Identifikasi variabel apa saja yang dibutuhkan
//identifikasi jenis percabangan yang sesuai dengan kebutuhan tersebut
//Merancang alur jalannya program 


//PEMECAHAN KASUS
//Lakukan pengkodean (coding) dari hasil analisis anda


//DISKUSI
//Sebutkan kondisi percabangan yang diperlukan
//Bagaimana urutan logika percabangannya?


//REFLEKSI
//Apakah penjumlahan diskon sudah sesuai dengan dunia nyata?
//Bagaimana jika ada batas maksimal diskon?

import java.util.Scanner;
public class latihanPercabangan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // daftar member (nama, alamat, no hp)
        String namaMember = "", alamatMember = "", noHPmember = "";
        String Jawab = "";

        //transaksi belanja
        String namaBarang = "";
        double harga = 0.0, jumlahBeli = 0.0, totalHarga = 0.0, diskon = 0.0, grandTotal = 0.0;

        // ditanyakan dulu mau daftar member atau tidak
        // berikan teks input
        System.out.print("Apakah anda ingin mendaftarkan member disini? (Y/T): ");
        Jawab = scanner.nextLine();

        //cek jawaban user, jawabannya Y atau T menggunakan IF
        //equals = case sensitive (perhatikan kapital/tidaknya ) 
        //equalsIgnoreCase = case none sensitive
        if (Jawab.equalsIgnoreCase("Y")) {
            //true / jawab Y
            System.out.print(" Nama anda : ");
            namaMember = scanner.nextLine();
            System.out.print(" Alamat anda : ");
            alamatMember = scanner.nextLine();
            System.out.print(" No HP anda : ");
            noHPmember = scanner.nextLine();

            System.out.print("Ingin lanjut berbelanja? (Y/T) : "); 
            Jawab = scanner.nextLine();
            if (Jawab.equalsIgnoreCase("Y")) {
                System.out.print("Nama Barang: ");
                namaBarang = scanner.nextLine();
                System.out.print("Harga: ");
                harga = scanner.nextDouble();
                System.out.print("Jumlah Beli: ");
                jumlahBeli = scanner.nextDouble();

                System.out.println();

                totalHarga = harga * jumlahBeli;
                System.out.println("jumlah beli: " + jumlahBeli );
                System.out.println("Total Harga: " + totalHarga);
                //hitung diskon
                if (totalHarga > 100000) {
                    diskon = totalHarga * 0.05 * 0.02  ;
                } else if (totalHarga > 300000) {
                    diskon = totalHarga * 0.1 * 0.02  ;
                } 
                
                System.out.println("Diskon: " + diskon);
                grandTotal = totalHarga - diskon;
            }
        } else {
            // Jawab no / T
            System.out.println("Selamat Berbelanja di Inimaret! ");
            
        } 
        // if (Jawab.equals("y") || Jawab.equals("Y")) {
        //     // Contoh: jawab y atau Y
            
           
        //      // input data member
        //      // jawab Y

        // } else {
            // jawab T
        }

    }


