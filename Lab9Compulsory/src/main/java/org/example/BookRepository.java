package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class BookRepository {
    private EntityManager em;

    public BookRepository(EntityManager em) {
        this.em = em;
    }

    public void create(Book book) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(book);
        transaction.commit();
    }

    public Book findById(int id) {
        return em.find(Book.class, id);
    }

    public List<Book> findAll() {
        TypedQuery<Book> query = em.createNamedQuery("Book.findAll", Book.class);
        return query.getResultList();
    }

    public List<Book> findByAuthor(Author author) {
        TypedQuery<Book> query = em.createNamedQuery("Book.findByAuthor", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }
}
