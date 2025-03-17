import java.util.ArrayList;
import java.util.Arrays;

public class Library {
    private String title;
    private String category;
    private int publishedDate;
    private ArrayList<String> author = new ArrayList<>();
    private String synopsis;
    private int similiarityWithPreviousBook;

    public Library() {
        this.title = "Default Title";
        this.category = "Default Category";
        this.publishedDate = 2000;
        this.author = new ArrayList<>(Arrays.asList("Author"));
        this.synopsis = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis tempus nunc nulla. Nunc velit ligula.";
    }

    public Library(String title, String category, int publishedDate, ArrayList<String> author, String synopsis) {
        this.title = title;
        this.category = category;
        this.publishedDate = publishedDate;
        this.author = author;
        this.synopsis = synopsis;
    }

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

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public int getSynopsisWordCount() {
        return this.synopsis.split("\\s+").length;
    }

    public void checkSimiliarity(Library library) {
        if (this.title.equals(library.title)) {
            this.similiarityWithPreviousBook += 20;
        }
        if (this.category.equals(library.category)) {
            this.similiarityWithPreviousBook += 20;
        }
        if (this.publishedDate == library.publishedDate) {
            this.similiarityWithPreviousBook += 20;
        }
        if (this.author.equals(library.author)) {
            this.similiarityWithPreviousBook += 20;
        }
        if (this.synopsis.equals(library.synopsis)) {
            this.similiarityWithPreviousBook += 20;
        }
    }

    public void cloneOjbect(Library library) {
        this.title = library.title;
        this.category = library.category;
        this.publishedDate = library.publishedDate;
        this.author = library.author;
        this.synopsis = library.synopsis;
        this.similiarityWithPreviousBook = 0;
    }

    public void displayInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Category: " + this.category);
        System.out.println("Published date: " + this.publishedDate);
        int counter = 0;
        for (String i : this.author) {
            System.out.println("Author " + (counter) + ": " + i);
            counter++;
        }
        System.out.println("Synopsys: " + this.synopsis);
        System.out.println("Synopsys word count: " + getSynopsisWordCount());
        System.out.println("Similiiarity with previous book: " + this.similiarityWithPreviousBook + "%");
        System.out.println("==========\n");
    }
}
