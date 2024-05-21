package com.example.bookcollection.controller;

import com.example.bookcollection.model.Book;
import com.example.bookcollection.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    @PutMapping("/{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book bookDetails) {
        Book book = bookRepository.findById(id).orElse(null);
        if (book != null) {
            book.setTitle(bookDetails.getTitle());
            book.setLanguage(bookDetails.getLanguage());
            book.setPublication_date(bookDetails.getPublication_date());
            book.setPages(bookDetails.getPages());
            book.setAuthors(bookDetails.getAuthors());
            return bookRepository.save(book);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable int id) {
        bookRepository.deleteById(id);
    }
}
