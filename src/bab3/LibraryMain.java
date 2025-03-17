import java.io.File;
import java.io.Writer;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibraryMain {
    private static void getBookInfoFromFile(String inputFilePath, String saveFilePath) {
        try {
            File file = new File(inputFilePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String[] currentBook = scanner.nextLine().split("; ");
                Library library = new Library();
                library.setTitle(currentBook[0]);
                library.setPublishedDate(Integer.parseInt(currentBook[1]));
                library.setAuthor(currentBook[2]);
                library.setCategory(currentBook[3]);
                library.setRoyalty((long) (Math.random() * 500000), Math.random() * 75);
                library.displayInfo();
                writeBookInfoToFile(saveFilePath, library.getInfo());
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found");
            e.printStackTrace();
        }
    }

    private static void writeBookInfoToFile(String filePath, String content) {
        try {
            File file = new File(filePath);
            if (file.createNewFile()) {
                System.err.println("Created new file in: " + file.getName());
            }
            FileWriter fileWriter = new FileWriter(filePath, true);
            Writer output;
            output = new BufferedWriter(fileWriter);
            output.append(content);
            output.close();
            fileWriter.close();
        } catch (IOException e) {
            System.err.println("Error:");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input file name: ");
        String inputFilePath = scanner.nextLine();
        System.out.print("Save file name: ");
        String saveFilePath = scanner.nextLine();
        getBookInfoFromFile(inputFilePath, saveFilePath);
        scanner.close();
    }
}
