public class Library {
    private String title;
    private String category;
    private int publishedDate;
    private long price;
    private double royalty;
    private String author;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPublishedDate(int publishedDate) {
        this.publishedDate = publishedDate;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setRoyalty() {
        this.royalty = 0.1 * this.price;
    }

    public void setRoyalty(long price) {
        this.price = price;
        this.royalty = 0.1 * this.price;
    }

    public void setRoyalty(long price, double percentage) {
        this.price = price;
        this.royalty = (percentage / 100) * this.price;
    }

    public long getPrice() {
        return this.price;
    }

    public double getRoyalty() {
        this.royalty = 0.1 * this.price;
        return this.royalty;
    }

    public double getRoyalty(long price) {
        this.price = price;
        this.royalty = 0.1 * this.price;
        return this.royalty;
    }

    public double getRoyalty(long price, double percentage) {
        this.price = price;
        this.royalty = (percentage / 100) * this.price;
        return this.royalty;
    }

    public void displayInfo() {
        System.out.println("Title: " + this.title);
        System.out.println("Category: " + this.category);
        System.out.println("Published date: " + this.publishedDate);
        System.out.println("Author: " + this.author);
        System.out.println("Price: " + this.price);
        System.out.println("Royalty: " + this.royalty);
        System.out.println();
    }

    public String getInfo() {
        return "Title: " + this.title + "\n" +
                "Category: " + this.category + "\n" +
                "Published date: " + this.publishedDate + "\n" +
                "Author: " + this.author + "\n" +
                "Price: " + this.price + "\n" +
                "Royalty: " + this.royalty + "\n\n";
    }
}
