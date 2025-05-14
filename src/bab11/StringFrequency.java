import java.util.HashMap;
import java.util.Scanner;
import java.util.StringTokenizer;

public class StringFrequency {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        HashMap<String, Integer> tokenCount = new HashMap<>();
        StringBuilder input = new StringBuilder();
        StringTokenizer stringTokenizer;

        if (args.length >= 1) {
            for (String i : args) {
                input.append(String.format(" %s", i.replaceAll("[^a-zA-Z ]", "").toLowerCase()));
            }
        } else {
            input.append(scanner.nextLine().replaceAll("[^a-zA-Z ]", "").toLowerCase());
        }

        scanner.close();

        stringTokenizer = new StringTokenizer(input.toString());

        while (stringTokenizer.hasMoreTokens()) {
            tokenCount.merge(stringTokenizer.nextToken(), 1, Integer::sum);
        }

        System.out.print("╭");

        for (int i = 0; i < 38; i++) {
            System.out.print("─");
        }

        System.out.println();

        System.out.printf(
                "│ %-20s\t│ %s\n",
                "Token",
                "Frekuensi");

        System.out.print("├");

        for (int i = 0; i < 38; i++) {
            System.out.print("─");
        }

        System.out.println();

        for (String i : tokenCount.keySet()) {
            System.out.printf(
                    "│ %-20s\t│%2d\n",
                    i,
                    tokenCount.get(i));
        }

        System.out.print("╰");

        for (int i = 0; i < 38; i++) {
            System.out.print("─");
        }

        System.out.println();
    }
}
