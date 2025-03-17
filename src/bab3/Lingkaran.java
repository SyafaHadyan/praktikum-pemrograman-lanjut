public class Lingkaran {
    int alas, tinggi;

    public Lingkaran() {
        this.alas = 5;
        this.tinggi = 5;
    }

    public Lingkaran(int alas, int tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public Lingkaran(String alas, String tinggi) {
        this.alas = parseToInteger(alas);
        this.tinggi = parseToInteger(tinggi);
    }

    private int parseToInteger(String input) {
        return Integer.parseInt(input);
    }

    public void setAlas(int alas) {
        this.alas = alas;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getAlas() {
        return alas;
    }

    public int getTinggi() {
        return tinggi;
    }

    public double hitungLuas() {
        double hasil = (double) (getTinggi() * getAlas()) / 2;
        return hasil;
    }

    public void displayMessage() {
        System.out.println("Hitung Luas : " + hitungLuas());
    }
}
