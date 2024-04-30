package org.example;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        AuthorRepository authorRepository = new AuthorRepository();
        GenreRepository genreRepository = new GenreRepository();
        BookRepository bookRepository = new BookRepository();

        // Create authors and genres
        Author shakespeare = new Author();
        shakespeare.setName("William Shakespeare");
        authorRepository.create(shakespeare);

        Author adams = new Author();
        adams.setName("Douglas Adams");
        authorRepository.create(adams);

        Genre tragedy = new Genre();
        tragedy.setName("Tragedy");
        genreRepository.create(tragedy);

        Genre scienceFiction = new Genre();
        scienceFiction.setName("Science Fiction");
        genreRepository.create(scienceFiction);

        // Create books
        Book romeoAndJuliet = new Book();
        romeoAndJuliet.setTitle("Romeo and Juliet");
        romeoAndJuliet.setAuthors(List.of(shakespeare));
        romeoAndJuliet.setGenre(tragedy);
        romeoAndJuliet.setPublicationYear(1597);
        bookRepository.create(romeoAndJuliet);

        Book hitchhikersGuide = new Book();
        hitchhikersGuide.setTitle("The Hitchhiker's Guide to the Galaxy");
        hitchhikersGuide.setAuthors(List.of(adams));
        hitchhikersGuide.setGenre(scienceFiction);
        hitchhikersGuide.setPublicationYear(1979);
        bookRepository.create(hitchhikersGuide);

        // Find entities
        Author foundAuthor = authorRepository.findById(1);
        System.out.println("Found author: " + foundAuthor.getName());

        List<Genre> foundGenres = genreRepository.findByName("Tragedy");
        System.out.println("Found genres:");
        for (Genre genre : foundGenres) {
            System.out.println(genre.getName());
        }

        List<Book> foundBooks = bookRepository.findByTitle("Romeo");
        System.out.println("Found books:");
        for (Book book : foundBooks) {
            System.out.println(book.getTitle());
        }

        EntityManagerFactorySingleton.closeEntityManagerFactory();
    }
}
