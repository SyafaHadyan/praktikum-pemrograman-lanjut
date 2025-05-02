import java.io.File;

public class Rename {
    private static final String FILE_OLD = "rename.txt";
    private static final String FILE_NEW = "result.txt";

    public static void main(String[] args) {
        File file = new File(FILE_OLD);
        File newFile = new File(FILE_NEW);

        if (file.exists() && !newFile.exists()) {
            boolean result = file.renameTo(newFile);
            System.out.println((result ? "Berhasil" : "Gagal") + " mengubah nama file");
        } else if (!file.exists()) {
            System.err.println("File tidak ada");
        } else {
            System.err.println("File dengan nama baru sudah ada");
        }
    }
}
