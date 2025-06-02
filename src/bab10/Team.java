import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class TeamRepository {
}

class TeamA extends TeamRepository {
    static List<Integer> height = new ArrayList<>(
            Arrays.asList(168, 170, 165, 168, 172, 170, 169, 165, 171, 166));
    static List<Integer> weight = new ArrayList<>(
            Arrays.asList(50, 60, 56, 55, 60, 70, 66, 56, 72, 56));
}

class TeamB extends TeamRepository {
    static List<Integer> height = new ArrayList<>(
            Arrays.asList(170, 167, 165, 166, 168, 175, 172, 171, 168, 169));
    static List<Integer> weight = new ArrayList<>(
            Arrays.asList(66, 60, 59, 58, 58, 71, 68, 68, 65, 60));
}

class TeamC extends TeamRepository {
    static List<Integer> height;
    static List<Integer> weight;
}

class Batch {
    public static void heightA() {
        System.out.println("TEAM A HEIGHT");
        System.out.println(TeamA.height);
        System.out.println();

        Collections.sort(TeamA.height);

        System.out.println("TEAM A HEIGHT SORTED ASC");
        System.out.println(TeamA.height);
        System.out.println();

        Collections.reverse(TeamA.height);
        System.out.println("TEAM A HEIGHT SORTED DESC");
        System.out.println(TeamA.height);
        System.out.println();
    }

    public static void heightB() {
        System.out.println("TEAM B HEIGHT");
        System.out.println(TeamB.height);
        System.out.println();

        Collections.sort(TeamB.height);

        System.out.println("TEAM B HEIGHT SORTED ASC");
        System.out.println(TeamB.height);
        System.out.println();

        Collections.reverse(TeamB.height);
        System.out.println("TEAM B HEIGHT SORTED DESC");
        System.out.println(TeamB.height);
        System.out.println();
    }

    public static void heightC() {
        System.out.println("TEAM C HEIGHT");
        System.out.println(TeamC.height);
        System.out.println();

        Collections.sort(TeamC.height);

        System.out.println("TEAM C HEIGHT SORTED ASC");
        System.out.println(TeamC.height);
        System.out.println();

        Collections.reverse(TeamC.height);
        System.out.println("TEAM C HEIGHT SORTED DESC");
        System.out.println(TeamC.height);
        System.out.println();
    }

    public static void weightA() {
        System.out.println("TEAM A WEIGHT");
        System.out.println(TeamA.weight);
        System.out.println();

        Collections.sort(TeamA.weight);

        System.out.println("TEAM A WEIGHT SORTED ASC");
        System.out.println(TeamA.weight);
        System.out.println();

        Collections.reverse(TeamA.weight);
        System.out.println("TEAM A WEIGHT SORTED DESC");
        System.out.println(TeamA.weight);
        System.out.println();
    }

    public static void weightB() {
        System.out.println("TEAM B WEIGHT");
        System.out.println(TeamB.weight);
        System.out.println();

        Collections.sort(TeamB.weight);

        System.out.println("TEAM B WEIGHT SORTED ASC");
        System.out.println(TeamB.weight);
        System.out.println();

        Collections.reverse(TeamB.weight);
        System.out.println("TEAM B WEIGHT SORTED DESC");
        System.out.println(TeamB.weight);
        System.out.println();
    }

    public static void weightC() {
        System.out.println("TEAM C WEIGHT");
        System.out.println(TeamC.weight);
        System.out.println();

        Collections.sort(TeamC.weight);

        System.out.println("TEAM C WEIGHT SORTED ASC");
        System.out.println(TeamC.weight);
        System.out.println();

        Collections.reverse(TeamC.weight);
        System.out.println("TEAM C WEIGHT SORTED DESC");
        System.out.println(TeamC.weight);
        System.out.println();
    }

    public static void statusA() {
        System.out.println("TEAM A MAX HEIGHT");
        System.out.println(Collections.max(TeamA.height));

        System.out.println("TEAM A MIN HEIGHT");
        System.out.println(Collections.min(TeamA.height));

        System.out.println("TEAM A MAX WEIGHT");
        System.out.println(Collections.max(TeamA.weight));

        System.out.println("TEAM A MIN WEIGHT");
        System.out.println(Collections.min(TeamA.weight));
    }

    public static void statusB() {
        System.out.println("TEAM B MAX HEIGHT");
        System.out.println(Collections.max(TeamB.height));

        System.out.println("TEAM B MIN HEIGHT");
        System.out.println(Collections.min(TeamB.height));

        System.out.println("TEAM B MAX WEIGHT");
        System.out.println(Collections.max(TeamB.weight));

        System.out.println("TEAM B MIN WEIGHT");
        System.out.println(Collections.min(TeamB.weight));
    }

    public static void searchItem(List<Integer> list, int search) {
        int key = Collections.binarySearch(list, search);

        if (key > 0) {
            System.out.printf(
                    "Team value %d found at index %d\n",
                    search,
                    key);
        } else {
            System.out.printf(
                    "Team value %d could not be found\n",
                    search);
        }
    }

    public static List<Integer> searchCollection(List<Integer> a, List<Integer> b) {
        Set<Integer> result = new HashSet<>();

        for (int key : a) {
            if (b.contains(key)) {
                result.add(key);
            }
        }

        return new ArrayList<Integer>(result);
    }
}

public class Team {
    private static Scanner scanner = new Scanner(System.in);

    private static void soal1() {
        Batch.heightA();
        scanner.nextLine();

        Batch.heightB();
        scanner.nextLine();

        Batch.weightA();
        scanner.nextLine();

        Batch.weightB();
        scanner.nextLine();

        Batch.statusA();
        scanner.nextLine();

        Batch.statusB();
        scanner.nextLine();

        System.out.println("COPY FROM B TO C");

        TeamC.height = new ArrayList<>(TeamB.height);
        TeamC.weight = new ArrayList<>(TeamB.weight);

        Batch.heightC();
        scanner.nextLine();

        Batch.weightC();
    }

    private static void soal2() {
        int firstHeightB = 168;
        int secondHeightB = 160;

        Collections.sort(TeamA.height);
        Collections.sort(TeamA.weight);
        Collections.sort(TeamB.height);
        Collections.sort(TeamB.weight);

        Batch.searchItem(TeamB.height, firstHeightB);
        Batch.searchItem(TeamB.height, secondHeightB);

        int firstWeightA = 56;
        int secondWeightA = 53;

        Batch.searchItem(TeamA.weight, firstWeightA);
        Batch.searchItem(TeamA.weight, secondWeightA);

        System.out.printf(
                "Team A height exist in B %s\n",
                Batch.searchCollection(TeamA.height, TeamB.height));

        System.out.printf(
                "Team A weight exist in B %s\n",
                Batch.searchCollection(TeamA.weight, TeamB.weight));
    }

    public static void main(String[] args) {
        soal1();
        soal2();
        scanner.close();
    }
}
