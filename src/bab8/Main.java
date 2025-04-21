import java.util.Scanner;

class InputStruct {
    String nama;
    int umur;
}

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        InputStruct kucingInput = new InputStruct();
        kucingInput.nama = "Kucing";
        kucingInput.umur = 3;

        Hewan kucing = new Hewan(kucingInput.nama, kucingInput.umur);
        kucing.makan();
        kucing.berjalan();
        kucing.bersuara();
        kucing.tampilkanNama();
        kucing.tampilkanUmur();

        scanner.close();
    }
}
