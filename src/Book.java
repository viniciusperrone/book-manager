public class Book {
    private String title;
    private String author;
    private int yearPublication;

    public Book(String title, String author, int yearPublication) {
        this.title = title;
        this.author = author;
        this.yearPublication = yearPublication;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public int getYearPublication() {
        return this.yearPublication;
    }

    @Override
    public String toString() {
        return "\"" + title + "\", de " + author + " (" + yearPublication + ")";
    }
}
