public class Manusia {
    private final String STRING_FORMAT = "%-20s: %s";
    private String nama;
    private boolean jenisKelamin;
    private String NIK;
    private boolean menikah;

    public Manusia() {
        this.nama = "Default Name";
        this.jenisKelamin = true;
        this.NIK = "35123456789";
        this.menikah = false;
    }

    public Manusia(String nama, boolean jenisKelamin, String NIK, boolean menikah) {
        this.nama = nama;
        this.jenisKelamin = jenisKelamin;
        this.NIK = NIK;
        this.menikah = menikah;
    }

    private void printSeparator(int count) {
        System.out.println();
        for (int i = 0; i < count; i++) {
            System.out.print("=");
        }
        System.out.println("\n");
    }

    public String formatString(String head, String message, boolean newLine) {
        return String.format(STRING_FORMAT, head, message) + ((newLine) ? "\n" : "");
    }

    public String formatString(String head, double message, boolean newLine) {
        return String.format(STRING_FORMAT, head, message) + ((newLine) ? "\n" : "");
    }

    public void separator() {
        printSeparator(35);
    }

    public void separator(int count) {
        printSeparator(count);
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setJenisKelamin(boolean jenisKelamin) {
        this.jenisKelamin = jenisKelamin;
    }

    public void setNIK(String NIK) {
        this.NIK = NIK;
    }

    public void setStatusMenikah(boolean menikah) {
        this.menikah = menikah;
    }

    public String getNama() {
        return this.nama;
    }

    public boolean getJenisKelamin() {
        return this.jenisKelamin;
    }

    public String getNIK() {
        return this.NIK;
    }

    public boolean getStatusMenikah() {
        return this.menikah;
    }

    public double getTunjangan() {
        if (this.menikah) {
            if (this.jenisKelamin) {
                return 25d;
            } else {
                return 20d;
            }
        } else {
            return 15d;
        }
    }

    public double getPendapatan() {
        return getTunjangan();
    }

    public String toString() {
        return formatString("Nama", this.nama, true) +
                formatString("NIK", this.NIK, true) +
                formatString("Jenis Kelamin",
                        ((this.jenisKelamin) ? "Laki-laki" : "Perempuan"), true)
                +
                formatString("Pendapatan", this.getPendapatan(), false);
    }
}
