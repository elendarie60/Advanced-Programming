package DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends GenericDAO<Book> {

    public BookDAO(Connection connection) {
        super(connection);
    }

    public void create(Book book) throws SQLException {
        String sql = "INSERT INTO books (title, author, genre, publication_year) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, book.getTitle());
            statement.setString(2, book.getAuthor()); // Assuming author's name is stored as a string
            statement.setString(3, book.getGenre());
            statement.setInt(4, book.getPublicationYear());
            statement.executeUpdate();
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                book.setId(generatedKeys.getInt(1));
            }
        }
    }

    public List<Book> findAll() throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                books.add(mapResultSetToEntity(resultSet));
            }
        }
        return books;
    }

    public Book findByName(String title) throws SQLException {
        Book book = null;
        String sql = "SELECT * FROM books WHERE title = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    book = mapResultSetToEntity(resultSet);
                }
            }
        }
        return book;
    }

    public Book findById(int id) throws SQLException {
        public Book findByName(String name) throws SQLException {

            return null;
        }  Book book = null;
        String sql = "SELECT * FROM books WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    book = mapResultSetToEntity(resultSet);
                }
            }
        }
        return book;
    }

    protected Book mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        Book book = new Book();
        book.setId(resultSet.getInt("id"));
        book.setTitle(resultSet.getString("title"));
        book.setAuthor(resultSet.getString("author"));
        book.setGenre(resultSet.getString("genre"));
        book.setPublicationYear(resultSet.getInt("publication_year"));
        return book;
    }
}