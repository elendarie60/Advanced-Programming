package controller;

import entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

public class AuthorController {
    private EntityManagerFactory emf;

    public AuthorController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public void create(Author author) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(author);
        em.getTransaction().commit();
        em.close();
    }

    public Author findByName(String name) {
        EntityManager em = emf.createEntityManager();
        Query query = em.createQuery("SELECT a FROM Author a WHERE a.name = :name");
        query.setParameter("name", name);
        List<Author> authors = query.getResultList();
        em.close();
        return authors.isEmpty() ? null : authors.get(0);
    }
}
