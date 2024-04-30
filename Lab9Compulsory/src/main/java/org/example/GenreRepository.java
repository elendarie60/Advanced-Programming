package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

public class GenreRepository {
    private EntityManager em;

    public GenreRepository(EntityManager em) {
        this.em = em;
    }

    public void create(Genre genre) {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(genre);
        transaction.commit();
    }

    public Genre findById(int id) {
        return em.find(Genre.class, id);
    }

    public List<Genre> findAll() {
        TypedQuery<Genre> query = em.createQuery("SELECT g FROM Genre g", Genre.class);
        return query.getResultList();
    }
}
