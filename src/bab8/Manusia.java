public class Manusia implements MakhlukHidup, Identitas {
    private String nama;
    private int umur;

    public Manusia(String nama, int umur) {
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
        System.out.println("Makan pakai sendok garpu");
    }

    @Override
    public void berjalan() {
        System.out.println("Jalan pakai dua kaki");
    }

    @Override
    public void bersuara() {
        System.out.println("Suaranya merdu");
    }

    @Override
    public void tampilkanNama() {
        System.out.printf("Nama saya: %s\n", getNama());
    }

    @Override
    public void tampilkanUmur() {
        System.out.printf("Umur saya: %s tahun\n", getUmur());
    }
}
