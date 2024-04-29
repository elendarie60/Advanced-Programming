package DAO;
import java.util.List;

public class Book extends AbstractModel{
    private int id;
    private String title;
    private Author author;
    private Genre genre;
    private int publicationYear;
    private List<String> authors;

    public Book() {
    }

    public Book(String title, Author author, Genre genre, int publicationYear) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publicationYear = publicationYear;
    }

    // Getters and setters for id, title, author, genre, and publicationYear

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }

}