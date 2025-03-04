package bab1;

public class Book {
    private int page;
    private int pageSize;
    private int dailyWord;
    private int sheet = page / 2;

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setDailyWord(int dailyWord) {
        this.dailyWord = dailyWord;
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public double countToEnd() {
        return ((page * pageSize) / dailyWord);
    }
}
