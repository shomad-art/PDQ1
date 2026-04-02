public class tipeData { //blok class (ini komen. tidak dibaca oleh sistem)
    //blok main -->psvm+tab
    public static void main(String[] args) {
        //coding

        /*universitas dinamika membutuhkan aplikasi sederhana
         untuk mencatat biodata mahasiswa. apa saja variabel dan tipe 
         data yang diperlukan?

         NIM --> String
         Nama --> String
         Alamat --> String
         No.HP --> String 
         Jenis Kelamin --> String
         Program Studi --> String
         Dosen Wali --> String
         Sisa BOP --> Int

         Int : utk perhitungan/kalkulasi angka
         */

         //1. Deklarasi variabel
         String nim = "25410100049";
         String nama = "Abdusshomad Muhibbilllah";
         String alamat = "Jl. Brigjend Katamso no. 26";
         String noHp = "085606325095";
         String jenisKelamin = "Laki-laki";
         String programStudi = "Sistem Informasi";
         String dosenWali = "Bu Yani";
         int sisaBOP = 1000000;

         //2. Print nilai variabel --> sout+tab
         // Cara 1: print tanpa teks tambahan
         System.out.println(nim);
         
         // Cara 2: print dengan teks tambahan
         System.out.println("NIM mahasiswa adalah " +nim+ ", Dengan nama " +nama+ ", asal "+alamat+ ", dengan nomor HP " +noHp+ ", jenis kelamin " +jenisKelamin+ ", program studi " +programStudi+ ", dosen wali " +dosenWali+ ", sisa BOP " +sisaBOP);

         //dengan operator escape : \n (utk enter ke baris baru saat di print)
         System.out.println("NIM \t\t: " +nim+ "\nNama \t\t: " +nama+ "\nAlamat \t\t: " +alamat+ "\nNo.HP \t\t: " +noHp+ "\nJenis Kelamin \t: " +jenisKelamin+ "\nProgram Studi \t: " +programStudi+ "\nDosen Wali \t: " +dosenWali+ "\nSisa BOP \t: " +sisaBOP);
         

        


    }
}
