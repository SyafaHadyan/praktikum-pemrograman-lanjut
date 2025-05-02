import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class BacaFile2 {
    private static final String FILE = "test2.txt";

    public static void main(String[] args) {
        File file = new File(FILE);

        if (file.exists() && file.canRead()) {
            try (FileReader fileReader = new FileReader(FILE);
                    Scanner scanner = new Scanner(fileReader)) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (IOException e) {
                System.err.println("Gagal membaca file");
            }
        } else {
            System.err.println("File tidak ada atau file tidak bisa dibaca");
        }
    }
}
