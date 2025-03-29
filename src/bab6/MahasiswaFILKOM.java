public class MahasiswaFILKOM extends Manusia {

    private String NIM;
    private double IPK;

    public MahasiswaFILKOM() {
        super();
        this.NIM = "241232267";
        this.IPK = 4d;
    }

    public MahasiswaFILKOM(String NIM, double IPK, String nama, boolean jenisKelamin, String NIK, boolean menikah) {
        super(nama, jenisKelamin, NIK, menikah);
        this.NIM = NIM;
        this.IPK = IPK;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public void setIPK(double IPK) {
        this.IPK = IPK;
    }

    public String getNIM() {
        return this.NIM;
    }

    public double getIPK() {
        return this.IPK;
    }

    public double getBeasiswa() {
        if (this.IPK >= 3d && this.IPK <= 3.5) {
            return 50d;
        } else if (this.IPK >= 3.5 && this.IPK <= 4d) {
            return 75d;
        }

        return 0d;
    }

    public String getStatus() {
        String result = "";

        switch (this.NIM.charAt(6)) {
            case '2':
                result = result.concat("Teknik Informatika");
                break;
            case '3':
                result = result.concat("Teknik Komputer");
                break;
            case '4':
                result = result.concat("Sistem Informasi");
                break;
            case '6':
                result = result.concat("Pendidikan Teknologi Informasi");
                break;
            case '7':
                result = result.concat("Teknologi Informasi");
                break;
            default:
                result = result.concat("Not found");
        }

        result = result.concat(", 20" + this.NIM.substring(0, 2));

        return result;
    }

    public String toString() {
        return super.toString() + "\n" +
                formatString("NIM", this.NIM, true) +
                formatString("IPK", this.IPK, true) +
                formatString("Status Mahasiswa", getStatus(), false);
    }
}
