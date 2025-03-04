package bab1;

import java.util.ArrayList;

public class Library {
    private String title;
    private String category;
    private int publishedDate;
    private ArrayList<String> author = new ArrayList<>();

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setAuthor(ArrayList<String> author) {
        this.author = author;
    }

    public void displayInfo() {
        System.out.println("Title: " + title);
        System.out.println("Category: " + category);
        System.out.println("Published date: " + publishedDate);
        int counter = 0;
        for (String i : author) {
            System.out.println("Author " + (counter) + ": " + i);
            counter++;
        }
        System.out.println("==========\n");
    }
}
