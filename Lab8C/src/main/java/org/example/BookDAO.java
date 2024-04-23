package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    public void create(int year, String title, int authorId, String genre) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "INSERT INTO books (year, title, author_id, genre_id) VALUES (?, ?, ?, ?)")) {
            pstmt.setInt(1, year);
            pstmt.setString(2, title);
            pstmt.setInt(3, authorId);
            GenreDAO genreDAO = new GenreDAO();
            Integer genreId = genreDAO.findByName(genre);
            pstmt.setInt(4, genreId);
            pstmt.executeUpdate();
        }
    }

    public List<Book> getAllBooks() throws SQLException {
        Connection con = Database.getConnection();
        List<Book> books = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM books")) {
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book(
                            rs.getInt("id"),
                            rs.getInt("year"),
                            rs.getString("title"),
                            rs.getInt("author_id"),
                            rs.getInt("genre_id")
                    );
                    books.add(book);
                }
            }
        }
        return books;
    }

    public List<Book> findByTitle(String title) throws SQLException {
        Connection con = Database.getConnection();
        List<Book> books = new ArrayList<>();
        try (PreparedStatement pstmt = con.prepareStatement(
                "SELECT * FROM books WHERE title LIKE ?")) {
            pstmt.setString(1, "%" + title + "%");
            try (ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book(
                            rs.getInt("id"),
                            rs.getInt("year"),
                            rs.getString("title"),
                            rs.getInt("author_id"),
                            rs.getInt("genre_id")
                    );
                    books.add(book);
                }
            }
        }
        return books;
    }

    public void deleteById(int id) throws SQLException {
        Connection con = Database.getConnection();
        try (PreparedStatement pstmt = con.prepareStatement(
                "DELETE FROM books WHERE id = ?")) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        }
    }
}
