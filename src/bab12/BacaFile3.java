import java.io.IOException;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class BacaFile3 {
    private static final String FILE = "test3.txt";

    public static void main(String[] args) {
        Path paths = Paths.get(FILE);
        File file = paths.toFile();

        if (file.exists() && file.canRead()) {
            List<String> text = null;
            try {
                text = Files.readAllLines(paths);
            } catch (IOException e) {
                System.err.println("Gagal membaca file");
            } finally {
                for (String i : text) {
                    System.out.println(i);
                }
            }
        } else {
            System.err.println("File tidak ada atau file tidak bisa dibaca");
        }
    }
}
