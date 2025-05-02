import java.io.File;
import java.util.Date;

public class FileInfo {
    private static final String FILE = "test1.txt";

    public static void main(String[] args) {
        File file = new File(FILE);

        System.out.println(String.format("Name: %s", file.getName()));
        System.out.println(String.format("Size: %d bytes", file.length()));
        System.out.println(String.format("Absolute Path: %s", file.getAbsolutePath()));
        System.out.println(String.format("Last Modified: %s", new Date(file.lastModified())));
        System.out.println(String.format("Write: %b", file.canWrite()));
        System.out.println(String.format("Execute: %b", file.canExecute()));
        System.out.println(String.format("Hidden: %b", file.isHidden()));
    }
}
