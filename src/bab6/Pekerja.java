import java.time.LocalDate;

public class Pekerja extends Manusia {
    private double gaji;
    private LocalDate tahunMasuk;
    private int jumlahAnak;
    private LocalDate localDate = LocalDate.now();

    public Pekerja() {
        super();
        this.gaji = 5000000d;
        this.tahunMasuk = LocalDate.now();
        this.jumlahAnak = 0;
    }

    public Pekerja(double gaji, LocalDate tahunMasuk, int jumlahAnak, String nama, boolean jenisKelamin, String NIK,
            boolean menikah) {
        super(nama, jenisKelamin, NIK, menikah);
        this.gaji = gaji;
        this.tahunMasuk = tahunMasuk;
        this.jumlahAnak = jumlahAnak;
    }

    public void setGaji(double gaji) {
        this.gaji = gaji;
    }

    public void setTahunMasuk(LocalDate tahunMasuk) {
        this.tahunMasuk = tahunMasuk;
    }

    public void setJumlahAnak(int jumlahAnak) {
        this.jumlahAnak = jumlahAnak;
    }

    public double getGaji() {
        return this.gaji;
    }

    public LocalDate getTahunMasuk() {
        return this.tahunMasuk;
    }

    public int getJumlahAnak() {
        return this.jumlahAnak;
    }

    public double getBonus() {
        double extra = getJumlahAnak() * 20d;

        if (localDate.getYear() - tahunMasuk.getYear() <= 5) {
            return 0.05 * this.gaji + super.getTunjangan() + extra;
        } else if (localDate.getYear() - tahunMasuk.getYear() <= 10) {
            return 0.1 * this.gaji + super.getTunjangan() + extra;
        }
        return 0.15 * this.gaji + super.getTunjangan() + extra;
    }

    public String toString() {
        return formatString("Nama", super.getNama(), true) +
                formatString("NIK", super.getNIK(), true) +
                formatString("Jenis Kelamin",
                        ((super.getJenisKelamin()) ? "Laki-laki" : "Perempuan"), true)
                +
                formatString("Pendapatan", this.gaji + getBonus(), true) +
                formatString("Tahun Masuk", this.tahunMasuk.getYear(), true) +
                formatString("Jumlah Anak", this.jumlahAnak, true) +
                formatString("Gaji", this.gaji, false);
    }
}
