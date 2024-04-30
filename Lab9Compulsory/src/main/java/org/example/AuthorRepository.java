package org.example;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class AuthorRepository {
    private EntityManager em;

    public AuthorRepository(EntityManager em) {
        this.em = em;
    }

    public void create(Author author) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(author);
        transaction.commit();
    }

    public Author findById(int id) {
        return em.find(Author.class, id);
    }

    public List<Author> findAll() {
        TypedQuery<Author> query = em.createNamedQuery("Author.findAll", Author.class);
        return query.getResultList();
    }
}
