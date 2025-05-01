import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class StringConvertException extends Exception {
    public StringConvertException(String message) {
        super(message);
    }
}

class FileOutput {
    String[] fileContent;
    String currentLine;
    int totalLength;
    int ptr;
}

public class FileReaderExample {
    static final String[] CONVERSION_LIST = new String[] {
            "pertama.",
            "kedua.",
            "ketiga.",
            "keempat.",
            "kelima.",
            "keenam.",
            "ketujuh.",
            "kedelapan.",
            "kesembilan.",
            "kesepuluh."
    };
    static final String[] CONVERSION_RESULT = new String[] {
            "ke-1.",
            "ke-2.",
            "ke-3.",
            "ke-4.",
            "ke-5.",
            "ke-6.",
            "ke-7.",
            "ke-8.",
            "ke-9.",
            "ke-10.",
    };

    private static String convertToNumber(String s) throws StringConvertException {
        String result = "";

        for (int i = 0; i < CONVERSION_LIST.length; i++) {
            if (s.endsWith(CONVERSION_LIST[i])) {
                result = s.replace(CONVERSION_LIST[i], CONVERSION_RESULT[i]);
                break;
            }
        }

        if (result.isEmpty()) {
            throw new StringConvertException("Error kata tidak bisa dikonversi menjadi angka.");
        }

        return result;
    }

    public static void main(String[] args) {
        FileOutput fileOutput = null;
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        Scanner scanner = null;

        try {
            fileOutput = new FileOutput();
            fileReader = new FileReader("data.txt");
            bufferedReader = new BufferedReader(fileReader);
            scanner = new Scanner(new FileReader("data.txt"));

            int lineCount = 0;
            while (scanner.hasNextLine()) {
                scanner.nextLine();
                ++lineCount;
            }

            fileOutput.fileContent = new String[lineCount];
            fileOutput.ptr = 0;
            fileOutput.totalLength = 0;

            System.out.println("File content:\n");

            while ((fileOutput.currentLine = bufferedReader.readLine()) != null) {
                fileOutput.fileContent[fileOutput.ptr++] = fileOutput.currentLine;
                fileOutput.totalLength += fileOutput.currentLine.length();
            }
        } catch (FileNotFoundException e) {
            System.err.printf(
                    "File not found:\n\n%s\n",
                    e.getMessage());
        } catch (IOException e) {
            System.err.printf(
                    "IO Exception:\n\n%s\n",
                    e.getMessage());
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.err.printf(
                            "Failed to close file:\n\n%s\n",
                            e.getMessage());
                }
            }

            try {
                scanner.close();
            } catch (NullPointerException e) {
                System.err.printf(
                        "Failed to close scanner:\n\n%s\n",
                        e.getMessage());
            }

            try {
                for (int i = 0; i < fileOutput.fileContent.length; i++) {
                    try {
                        System.out.println(convertToNumber(fileOutput.fileContent[i]));
                    } catch (StringConvertException e) {
                        System.err.println(e.getMessage());
                    }
                }
            } catch (NullPointerException e) {
            }

            System.out.printf(
                    "\nSTATS:\nLine count: %d\nTotal length: %d\n",
                    fileOutput.ptr,
                    fileOutput.totalLength);
        }
    }
}
