public class Hewan implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    public Hewan(String nama, int umur) {
        setNama(nama);
        setUmur(umur);
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setUmur(int umur) {
        if (umur > 0) {
            this.umur = umur;
        } else {
            this.umur = 0;
        }
    }

    public String getNama() {
        return this.nama;
    }

    public int getUmur() {
        return this.umur;
    }

    @Override
    public void makan() {
        System.out.println("Makan pakai tangan dan mulut");
    }

    @Override
    public void berjalan() {
        System.out.println("Jalan pakai 4 kaki");
    }

    @Override
    public void bersuara() {
        System.out.println("Suaranya nggak jelas");
    }

    @Override
    public void tampilkanNama() {
        System.out.printf("Hewan bernama: %s\n", getNama());
    }

    @Override
    public void tampilkanUmur() {
        System.out.printf("Hewan %s berumur %s tahun\n", getNama(), getUmur());
    }
}
