public class Aritmatika {
    public void hitungPenjumlahan(int a, int b) {
        int nilai = a + b;
        System.out.println("Nilai penjumlahan adalah: " + nilai);
        hitungPerkalian(a, b);
    }

    public static void hitungPerkalian(int a, int b) {
        int nilai = a * b;
        System.out.println("Nilai perkalian adalah: " + nilai);
    }

    public double hitungPembagian(String a, String b) {
        return Double.parseDouble(a) / Double.parseDouble(b);
    }

    public static void hitungPengurangan(int a, int b) {
        int nilai = a - b;
        System.out.println("Nilai pengurangan adalah: " + nilai);
    }
}
