import java.io.File;
import java.util.ArrayList;

class DataStruct {
    File file;
}

public class RMDIR {
    private static DataStruct dataStruct = new DataStruct();

    private static void init(String[] args) {
        if (args.length != 1 || args[0] == null) {
            System.err.println("rm: missing operand");
            System.err.println("Usage: rm <args>");

            System.exit(1);
        }

        dataStruct.file = new File(args[0]);
        if (!dataStruct.file.exists()) {
            System.err.println(String.format(
                    "rm: cannot remove %s: No such file or directory",
                    dataStruct.file.getName()));

            System.exit(1);
        }
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

            System.exit(1);
        }

        return result;
    }

    private static void rmrf(ArrayList<File> files) {
        for (File i : files) {
            i.delete();
            System.out.println(String.format(
                    "Removed %s", i.getName()));
        }

        dataStruct.file.delete();
        System.out.println(String.format(
                "Removed %s directory",
                dataStruct.file.getName()));
    }

    public static void main(String[] args) {
        init(args);
        rmrf(ls());
    }
}
