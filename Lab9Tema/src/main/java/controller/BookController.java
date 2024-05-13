package controller;

import entity.Author;
import entity.Book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class BookController {
    private EntityManagerFactory emf;

    public BookController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Book book) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public List<Book> findByAuthor(Author author) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT b FROM Book b WHERE b.author = :author");
        query.setParameter("author", author);
        List<Book> books = query.getResultList();
        em.close();
        return books;
    }
}
