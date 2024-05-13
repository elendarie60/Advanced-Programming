package DAO;

import entity.Author;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

public class AuthorDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void create(Author author) {
        entityManager.persist(author);
    }

    public Author findById(Long id) {
        return entityManager.find(Author.class, id);
    }
}
