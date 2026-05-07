import java.util.Scanner;
public class tugasMinimarket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menu, total = 0;
        String namaBarang;

        do {
            System.out.println("1. Entri Data");
            System.out.println("2. Print Data");
            System.out.print("Pilih Menu: ");
            menu = scanner.nextInt();

            //percabangan menu
            switch(menu) {
                case 1:
                    System.out.println("===Entri Data===");

                    // data diulang hingga 5x >>> for
                    System.out.print("Berapa data yang dibutuhkan:");
                    iterasi = scanner.nextInt();
                    scanner.nextLine();
                    for (int i=1; i<= iterasi; i++);


            }

        }while (true);
    }
}