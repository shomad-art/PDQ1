public class mencoba2 {
    public static void main(String[] args) {
        // Menentukan variabel untuk mataa kuliah Bu Pradita 
        String namaDosen = "Bu Pradita";
        int jumlahTugas =4;
        double nilaiPertugas = 22.5; // menggunakan duoble untuk angka desimal
        
        // Melakukan operasi matematika (perkalian)
        double totalNilai = jumlahTugas * nilaiPertugas;

        // Menggunakan tipe data boolean untuk logika benar/salah 
        boolean siapUjian = true;  

        System.out.println("Dosen Pengampu: " + namaDosen);
        System.out.println("Total Tugas Yang Dikerjakan: " + jumlahTugas);
        System.out.println("Estimasi Total Nilai: " + totalNilai);
        System.out.println("Apakah Saya Siap Ujian?: " + siapUjian);

    }  
}
