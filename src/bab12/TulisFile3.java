import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TulisFile3 {
    private static final String FILE = "test3.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan teks yang akan disimpan: ");
        String text = scanner.nextLine();

        try (PrintWriter printWriter = new PrintWriter(FILE)) {
            printWriter.println(text);
        } catch (IOException e) {
            System.err.println("Gagal menulis ke file");
        } finally {
            scanner.close();
        }
    }
}
