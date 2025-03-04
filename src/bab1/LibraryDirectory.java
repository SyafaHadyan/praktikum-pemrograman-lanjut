package bab1;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.*;

public class LibraryDirectory {
    static final int BOOK_COUNT = 5;
    static final String[] bookCategoryName = {
            "Teknologi",
            "Filsafat",
            "Sejarah",
            "Agama",
            "Psikologi",
            "Politik",
            "Fiksi"
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Library> book = new ArrayList<>();
        for (int i = 0; i < bookCategoryName.length; i++) {
            for (int j = 0; j < BOOK_COUNT; j++) {
                Library current = new Library();
                ArrayList<String> bookAuthor = new ArrayList<>();
                System.out.println(bookCategoryName[i] + " Book: \n");
                System.out.print("Enter title: ");
                current.setTitle(input.nextLine());
                current.setCategory(bookCategoryName[i]);
                System.out.print("Enter published date: ");
                current.setPublishedDate(Integer.parseInt(input.nextLine()));
                System.out.print("Enter author name(s) (separated by spaces): ");
                String[] tempAuthorInput = input.nextLine().split("\\s+");
                for (String k : tempAuthorInput) {
                    bookAuthor.add(k);
                }
                System.out.println();
                current.setAuthor(bookAuthor);
                book.add(current);
            }
        }
        input.close();
        for (Library i : book) {
            i.displayInfo();
        }
    }
}
