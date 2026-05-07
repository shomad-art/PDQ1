import java.util.Scanner;

public class uts {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int [] gb = null;
        int [] jmlhHari = null;
        String [] namaHari = null;
        int [] jmlhPemakaian = null;

        int pilihan;
        do {
            System.out.println("\n==============================================");
            System.out.println("   SISTEM PENCATATAN PEMAKAIAN PENGGUNA INTERNET PERHARI   ");
            System.out.println("==============================================");
            System.out.println("1. Lebih dari 15 GB");
            System.out.println("2. Lebih dari 8 GB");
            System.out.println("3. Kurang dari 8 GB");
            System.out.print("Pilih menu (1-3)");
            pilihan = sc.nextInt();
            sc.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("\nMasukkan nama hari : ");
                    int jumlahData = sc.nextInt ();
                    sc.nextLine();

                   
                    gb = new int[jumlahData];
                    jmlhHari = new int [jumlahData];
                    namaHari = new String [jumlahData]; 
                    jmlhPemakaian = new int [jumlahData];

                    System.out.println("");



            }

        }
        


        sc.close();
    }
}
