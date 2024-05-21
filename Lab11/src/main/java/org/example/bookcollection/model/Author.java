package org.example.bookcollection.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_id;
    private String name;

    @ManyToMany(mappedBy = "authors")
    private List<Book> books;

    // Getters and setters
}