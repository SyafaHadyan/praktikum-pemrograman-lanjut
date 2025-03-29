import java.time.LocalDate;

public class Manager extends Pekerja {
    private String departemen;

    public Manager() {
        super();
        this.departemen = "Backend";
    }

    public Manager(String departemen, double gaji, LocalDate tahunMasuk, int jumlahAnak, String nama,
            boolean jenisKelamin, String NIK,
            boolean menikah) {
        super(gaji, tahunMasuk, jumlahAnak, nama, jenisKelamin, NIK, menikah);
        this.departemen = departemen;
    }

    public void setDepartemen(String departemen) {
        this.departemen = departemen;
    }

    public String getDepartemen() {
        return this.departemen;
    }

    @Override
    public double getTunjangan() {
        return super.getTunjangan() + (super.getGaji() * 0.1);
    }

    public String toString() {
        return formatString("Nama", super.getNama(), true) +
                formatString("NIK", super.getNIK(), true) +
                formatString("Jenis Kelamin",
                        ((super.getJenisKelamin()) ? "Laki-laki" : "Perempuan"), true)
                +
                formatString("Pendapatan", super.getGaji() + super.getBonus() + getTunjangan(), true) +
                formatString("Tahun Masuk", super.getTahunMasuk().getYear(), true) +
                formatString("Jumlah Anak", super.getJumlahAnak(), true) +
                formatString("Gaji", super.getGaji(), true) +
                formatString("Departemen", this.departemen, false);
    }
}
