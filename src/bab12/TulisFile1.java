import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class TulisFile1 {
    private static final String FILE = "test1.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan teks yang akan disimpan: ");
        String text = scanner.nextLine();

        try (FileWriter fileWriter = new FileWriter(FILE, true)) {
            fileWriter.write(text);
        } catch (IOException e) {
            System.err.println("Gagal menulis ke file");
        } finally {
            scanner.close();
        }
    }
}
