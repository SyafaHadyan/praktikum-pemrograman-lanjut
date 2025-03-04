package bab1;

import java.util.Scanner;
import java.util.ArrayList;

public class MainCar {
    static final int CAR_COUNT = 2;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Car> car = new ArrayList<>();
        for (int i = 0; i < CAR_COUNT; i++) {
            Car currentCar = new Car();
            System.out.print("Masukkan kecepatan: ");
            currentCar.setKecepatan(Integer.parseInt(input.nextLine()));
            System.out.print("Masukkan manufaktur: ");
            currentCar.setManufaktur(input.nextLine());
            System.out.print("Masukkan plat: ");
            currentCar.setNoPlat(input.nextLine());
            System.out.print("Masukkan warna: ");
            currentCar.setWarna(input.nextLine());
            System.out.print("Masukkan waktu: ");
            currentCar.setWaktu(Double.parseDouble(input.nextLine()));
            car.add(currentCar);
            System.out.println();
        }
        input.close();
        for (Car i : car) {
            i.displayMessage();
            System.out.println("================");
        }
    }
}
