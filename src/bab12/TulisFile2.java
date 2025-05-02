import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class TulisFile2 {
    private static final String FILE = "test2.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Path path = Paths.get(FILE);

        System.out.print("Masukkan teks yang akan disimpan: ");
        String text = scanner.nextLine();

        try {
            Files.writeString(path, text);
        } catch (IOException e) {
            System.err.println("Gagal menulis ke file");
        } finally {
            scanner.close();
        }
    }
}
