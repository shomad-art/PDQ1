import java.util.Scanner;
public class tugasKoEdwin {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // soal 1
        System.out.print("Masukkan jumlah baris: ");
        int n = scanner.nextInt();
        for (int i=1; i<=n; i++) {
            for (int j=1; j<=n; j++) {
                System.out.print("*");
            }
            System.out.println(" ");
        }
        System.out.println();

        // soal 2
        System.out.print("Masukkan jumlah baris: ");
        int m = scanner.nextInt();
        for (int i=1; i<=m; i++) {
            for (int j=1; j<=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // soal 3
        System.out.print("Masukkan jumlah baris: ");
        int p = scanner.nextInt();
        for (int t = p; t >= 1; t--) {
            for (int j=1; j <= t; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        // soal 4
        System.out.print("Masukkan jumlah baris: ");
        int q = scanner.nextInt();
        for (int w=1; w<=q; w++) {
            for (int j=1; j<=q-w; j++) {
                System.out.print(" ");
            }
            for (int k=1; k<=w; k++) {
                System.out.print("*");
            }
            System.out.println();
        }System.out.println();
    scanner.close();
        }
    }


