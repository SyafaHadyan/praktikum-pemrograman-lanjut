import java.io.File;
import java.util.ArrayList;

class DataStruct {
    File file;
}

public class RMDIR {
    private static DataStruct dataStruct = new DataStruct();
    private static final String FILE = "./delete";

    private static void init() {
        dataStruct.file = new File(FILE);
    }

    private static ArrayList<String> getFileSize(ArrayList<File> files) {
        ArrayList<String> result = new ArrayList<>();

        for (File file : files) {
            long size = file.length();
            String sizeString = "B";
            if (size <= 1024) {
            } else if (size <= 1024 * 1000) {
                sizeString = "KB";
                size /= 1000;
            } else {
                sizeString = "MB";
                size /= 1000 * 1000;
            }

            result.add(String.format("%d %s\t%s", size, sizeString, file.getName()));
        }

        return result;
    }

    private static ArrayList<File> ls() {
        ArrayList<File> result = new ArrayList<>();

        try {
            System.out.println("File list:");
            for (File file : dataStruct.file.listFiles()) {
                if (file.isFile() && file.exists()) {
                    result.add(file);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("ls: invalid directory");
        }

        return result;
    }

    private static void rmrf() {
        for Stri
    }

    public static void main(String[] args) {
        //
    }
}
