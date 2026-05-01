import java.util.Scanner;

public class latihanLoop2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double hargaBarang= 0.0;

        System.out.print("harga barang: ");
        hargaBarang = scanner.nextDouble();
        for (int baris=1; baris<6; baris++) {
                System.out.println(baris +" "+ hargaBarang );
                
        } scanner.close();
    }
    
}
