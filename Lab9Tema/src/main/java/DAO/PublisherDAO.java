package DAO;

package dao;

import entity.Publisher;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class PublisherDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Publisher publisher) {
        entityManager.persist(publisher);
    }

    public Publisher findById(Long id) {
        return entityManager.find(Publisher.class, id);
    }

    public List<Publisher> findByName(String name) {
        return entityManager.createQuery("SELECT p FROM Publisher p WHERE p.name = :name", Publisher.class)
                .setParameter("name", name)
                .getResultList();
    }
}
