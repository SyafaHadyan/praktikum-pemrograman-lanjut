import java.util.Scanner;

public class MainAritmatika {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nilaiPertama;
        int nilaiKedua;
        String stringNilaiPertama;
        String stringNilaiKedua;

        System.out.print("Masukkan nilai 1: ");
        nilaiPertama = scanner.nextInt();
        System.out.print("Masukkan nilai 2: ");
        nilaiKedua = scanner.nextInt();
        Aritmatika.hitungPengurangan(nilaiPertama, nilaiKedua);

        System.out.print("Masukkan nilai 1: ");
        nilaiPertama = scanner.nextInt();
        System.out.print("Masukkan nilai 2: ");
        nilaiKedua = scanner.nextInt();
        Aritmatika.hitungPerkalian(nilaiPertama, nilaiKedua);

        Aritmatika aritmatika = new Aritmatika();

        System.out.print("Masukkan nilai 1: ");
        nilaiPertama = scanner.nextInt();
        System.out.print("Masukkan nilai 2: ");
        nilaiKedua = scanner.nextInt();
        scanner.nextLine();
        aritmatika.hitungPenjumlahan(nilaiPertama, nilaiKedua);

        System.out.print("Masukkan nilai 1: ");
        stringNilaiPertama = scanner.nextLine();
        System.out.print("Masukkan nilai 2: ");
        stringNilaiKedua = scanner.nextLine();
        System.out
                .println("Hasil pembagian adalah: " + aritmatika.hitungPembagian(stringNilaiPertama, stringNilaiKedua));

        scanner.close();
    }
}
