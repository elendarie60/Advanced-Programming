package DAO;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        try {
            AuthorDAO authors = new AuthorDAO(Database.getConnection());
            GenreDAO genres = new GenreDAO(Database.getConnection());
            BookDAO books = new BookDAO(Database.getConnection());

            // Create authors and genres
            authors.create("William Shakespeare");
            genres.create("Tragedy");
            Database.getConnection().commit();

            // Create books
            books.create(1597, "Romeo and Juliet", "William Shakespeare", "Tragedy");
            books.create(1979, "The Hitchhiker's Guide to the Galaxy", "Douglas Adams", "Science fiction, Comedy, Adventure");
            Database.getConnection().commit();

            // Print all the books in the database
            List<Book> allBooks = books.getAllBooks();
            System.out.println("All Books:");
            for (Book book : allBooks) {
                System.out.println(book.getTitle() + " by " + book.getAuthor() + " - Genre: " + book.getGenre());
            }

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}