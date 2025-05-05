public class Book {
    private String title;
    private String author;
    private int yearPublication;
    private String genre;
    private int numberPages;

    public Book(String title, String author, int yearPublication, String genre, int numberPages) {
        this.title = title;
        this.author = author;
        this.yearPublication = yearPublication;
        this.genre = genre;
        this.numberPages = numberPages;
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

    public String getGenre() {
        return this.genre;
    }

    public int getNumberPages() {
        return this.numberPages;
    }

    @Override
    public String toString() {
        return "\"" + title + "\", de " + author + " (" + yearPublication + ")";
    }
}
