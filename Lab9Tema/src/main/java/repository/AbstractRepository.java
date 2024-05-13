package repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class AbstractRepository<T, ID> {

    @PersistenceContext
    protected EntityManager entityManager;

    private final Class<T> entityClass;
    private final Logger logger;

    public AbstractRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
        this.logger = Logger.getLogger(this.getClass().getName());
    }

    @Transactional
    public T findById(ID id) {
        try {
            return entityManager.find(entityClass, id);
        } catch (Exception e) {
            logException(e);
            return null;
        }
    }

    @Transactional
    public List<T> findAll() {
        try {
            return entityManager.createQuery("SELECT e FROM " + entityClass.getSimpleName() + " e", entityClass).getResultList();
        } catch (Exception e) {
            logException(e);
            return null;
        }
    }

    @Transactional
    public void save(T entity) {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            logException(e);
        }
    }

    @Transactional
    public void update(T entity) {
        try {
            entityManager.merge(entity);
        } catch (Exception e) {
            logException(e);
        }
    }

    @Transactional
    public void delete(T entity) {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            logException(e);
        }
    }

    private void logException(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        String stackTrace = sw.toString();
        logger.log(Level.SEVERE, stackTrace);
    }
}
