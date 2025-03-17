import java.util.Scanner;

public class Overloading {
    public static void hitungLuas(int a, int b) {
        int result = a * b;
        System.out.println("maka hasil luas : " + result);
    }

    public static void hitungLuas(double a, double b) {
        double result = a * b;
        System.out.println("maka hasil luas : " + result);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("masukkan nilai integer 1 : ");
        int firstInteger = scanner.nextInt();
        System.out.print("masukkan nilai integer 2 : ");
        int secondInteger = scanner.nextInt();
        hitungLuas(firstInteger, secondInteger);

        System.out.print("masukkan nilai double 1 : ");
        double firstDouble = scanner.nextDouble();
        System.out.print("masukkan nilai double 2 : ");
        double secondDouble = scanner.nextDouble();
        hitungLuas(firstDouble, secondDouble);

        scanner.close();
    }
}
