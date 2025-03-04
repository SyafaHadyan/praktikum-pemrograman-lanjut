package bab1;

public class Car {
    private String noPlat;
    private String warna;
    private String manufaktur;
    private int kecepatan;
    private double kecepatanSekon;
    private double waktu;
    private double sekon;
    private double jarak;

    public void setNoPlat(String s) {
        noPlat = s;
    }

    public void setWarna(String s) {
        warna = s;
    }

    public void setManufaktur(String s) {
        manufaktur = s;
    }

    public void setKecepatan(int i) {
        kecepatan = i;
        rubahKecepatan();
    }

    public void setWaktu(double d) {
        waktu = d;
        rubahSekon(d);
        hitungJarak();
    }

    private void rubahSekon(double d) {
        sekon = d * 3600;
    }

    private void rubahKecepatan() {
        kecepatanSekon = kecepatan * 0.2777777778;
    }

    private void hitungJarak() {
        jarak = kecepatan * waktu;
    }

    public void displayMessage() {
        System.out.println("Mobil anda adalah bermerek " + manufaktur);
        System.out.println("Mempunyai nomor plat " + noPlat);
        System.out.println("Serta memiliki warna " + warna);
        System.out.println("Dan mampu menempuh kecepatan " + kecepatan + " km/s");
        System.out.println("Atau " + kecepatanSekon + " m/s");
        System.out.println("Selama " + waktu + " jam");
        System.out.println("Atau selama " + sekon + " sekon");
        System.out.println("Dan menempuh jarak " + jarak + " km");
        System.out.println("Atau " + jarak * 1000 + " m");
    }
}
