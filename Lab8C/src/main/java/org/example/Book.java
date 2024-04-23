package org.example;
import java.util.Date;

public class Book {
    private int id;
    private int year;
    private String title;
    private int authorId;
    private int genreId;

    public Book(int id, int year, String title, int authorId, int genreId) {
        this.id = id;
        this.year = year;
        this.title = title;
        this.authorId = authorId;
        this.genreId = genreId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getGenreId() {
        return genreId;
    }

    public void setGenreId(int genreId) {
        this.genreId = genreId;
    }
}
