import java.io.File;

public class Delete {
    private static final String FILE = "delete.txt";

    public static void main(String[] args) {
        File file = new File(FILE);

        if (file.exists()) {
            boolean result = file.delete();
            System.out.println((result ? "Berhasil" : "Gagal") + " menghapus file");
        } else {
            System.err.println("File tidak ada");
        }
    }
}
