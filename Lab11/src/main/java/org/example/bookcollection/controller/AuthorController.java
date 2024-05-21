package org.example.bookcollection.controller;

import com.example.bookcollection.model.Author;
import com.example.bookcollection.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable int id) {
        return authorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorRepository.save(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable int id, @RequestBody Author authorDetails) {
        Author author = authorRepository.findById(id).orElse(null);
        if (author != null) {
            author.setName(authorDetails.getName());
            return authorRepository.save(author);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteAuthor(@PathVariable int id) {
        authorRepository.deleteById(id);
    }

    @GetMapping("/search")
    public List<Author> findAuthorsByName(@RequestParam String name) {
        return authorRepository.findByNameContaining(name);
    }
}