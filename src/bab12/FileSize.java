import java.io.File;
import java.util.ArrayList;

class DataStruct {
    File file;
}

public class FileSize {
    private static DataStruct dataStruct = new DataStruct();

    private static void init() {
        dataStruct.file = new File(System.getProperty("user.dir"));
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

    public static void main(String[] args) {
        init();

        ArrayList<String> fileSizeList = getFileSize(ls());

        System.out.println("File list:");
        for (String i : fileSizeList) {
            System.out.println(i);
        }
    }
}
