package bab1;

import java.util.Scanner;

public class FirstBook {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Book book = new Book();
        book.setPage(100);
        book.setPageSize(200);
        book.setDailyWord(100);
        System.out.println("Waktu yang diperlukan untuk menghabiskan buku adalah " + book.countToEnd() + " hari");
        input.close();
    }
}
