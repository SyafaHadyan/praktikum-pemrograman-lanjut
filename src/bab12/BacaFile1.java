import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BacaFile1 {
    private static final String FILE = "test1.txt";

    public static void main(String[] args) {
        File file = new File(FILE);

        if (file.exists() && file.canRead()) {
            try (FileReader fileReader = new FileReader(FILE);
                    BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                String line;

                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.err.println("Gagal membaca file");
            }
        } else {
            System.err.println("File tidak ada atau file tidak bisa dibaca");
        }
    }
}
