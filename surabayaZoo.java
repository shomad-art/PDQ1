import java.util.Scanner;

public class surabayaZoo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //Deklarasi array 
        String[] kategori = null;
        int[] harga = null;
        int[] jumlahBeli = null;

        int pilihanMenu;

        do{
            System.out.println("\n=== pemesanan tiket surabayaZoo ===");
            System.out.println("1. input kategori dan harga");
            System.out.println("2. input jumlah beli");
            System.out.println("3. lihat total bayar");
            System.out.println("4. keluar program");
            System.out.print("pilih menu (1-4): ");
            pilihanMenu = sc.nextInt();
            sc.nextLine(); // mencegah bug buffer (1)

            switch (pilihanMenu) {
                case 1:
                    System.out.print("\nMasukkan berapa banyak kategori tiket yang ingin dibuat: ");
                    int jumlahData = sc.nextInt();
                    sc.nextLine(); // mencegah bug buffer (2)
                    
                    // Inialisasi panjang array (dinamis)
                    kategori = new String[jumlahData];
                    harga = new int[jumlahData];
                    jumlahBeli = new int[jumlahData];
                    
                    System.out.println("--- Input kategori dan harga tiket ---");
                    // Menggunakan .length untuk batas iterasi for loop
                    for (int i = 0; i < kategori.length; i++) {
                        System.out.print("Nama kategori ke-" + (i+1) + " : ");
                        kategori[i] = sc.nextLine(); // untuk input teks

                        System.out.println("Harga tiket " + kategori[i] + " :Rp.  ");
                        harga[i] = sc.nextInt(); // untuk input angka
                        sc.nextLine(); // mencegah bug buffer (3)

                        
                    }
                    System.out.println("Data kategori dan harga berhasil disimpan!");
                    break;

                case 2:
                    if (kategori == null) {
                        System.out.println("\n--- Peringatan: Harap isi Menu 1 terlebih dahulu! ---");
                    } else {
                        System.out.println("\n--- Input Jumlah Beli Tiket ---");
                        // Menggunakan .length untuk iterasi [2]
                        for (int i = 0; i < jumlahBeli.length; i++) {
                            System.out.print("Berapa tiket '" + kategori[i] + "'(Rp. " + harga[i] + ") yang ingin dibeli? ");
                            jumlahBeli[i] = sc.nextInt(); 
                            
                        }
                        System.out.println("Jumlah beli berhasil disimpan!");

                    }
                    break;
                case 3:
                    if (kategori == null) {
                        System.out.println("\nPeringatan: Harap isi Menu 1 terlebih dahulu!");
                } else {
                    System.out.println("\n=============================");
                    System.out.println("      TOTAL BAYAR TIKET      ");
                    System.out.println("=============================");

                    //Total dibuat sebagai variabel biasa, bukan array [4, 5]
                    int totalSemua = 0;
                    for (int i = 0; i < kategori.length; i++) {
                        int subTotal = harga[i] * jumlahBeli[i];
                        totalSemua += subTotal; 
                        
                        if (jumlahBeli[i] > 0){
                            System.out.println("- " + kategori[i] + " : " + jumlahBeli[i] + " = Rp. " + subTotal);

                        }
                        
                    } 
                    System.out.println("===============================");
                    System.out.println("TOTAL KESELURUHAN : Rp. " +totalSemua);
                    System.out.println("===============================");
                }    
                break;

            case 4:
                System.out.println("\nTerima kasih telah menggunakan sistem pemesanan tiket surabayaZoo");
                break;

            default:
                System.out.println("\nPilihan tidak valid! Silakan pilih angka 1-4.");

            }    
        } while (pilihanMenu != 4);

        sc.close();
    }
}
