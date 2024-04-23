package org.example;
import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String args[]) {
        try {
            var authors = new AuthorDAO();
            authors.create("William Shakespeare");
            var genres = new GenreDAO();
            genres.create("Tragedy");
            Database.getConnection().commit();
            var books = new BookDAO(); //findByName
            Integer shakespeareId = authors.findByName("William Shakespeare");
            if (shakespeareId != null) {
                books.create(1597, "Romeo and Juliet", shakespeareId, "Tragedy");
            } else {
                System.err.println("Author William Shakespeare not found!");
            }
            books.create(1979, "The Hitchhiker's Guide to the Galaxy",
                    0, "Science fiction, Comedy, Adventure");
            Database.getConnection().commit();

            // Print all the books in the database
            List<Book> allBooks = books.getAllBooks();
            System.out.println("All Books in the Database:");
            for (Book book : allBooks) {
                System.out.println("ID: " + book.getId() + ", Title: " + book.getTitle() +
                        ", Year: " + book.getYear() + ", Author ID: " + book.getAuthorId() +
                        ", Genre ID: " + book.getGenreId());
            }

            Database.getConnection().close();
        } catch (SQLException e) {
            System.err.println(e);
            Database.rollback();
        }
    }
}
