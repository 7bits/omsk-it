package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.EntityDao;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

/**
 * Java Persistence API based implementation of the EntityDao.
 */
public class JpaEntityDao<Entity> implements EntityDao<Entity> {

    private static final Logger LOGGER = Logger.getLogger(JpaEntityDao.class);

    @PersistenceContext
    private EntityManager entityManager;

    private final Class<Entity> entityClass;

    public JpaEntityDao(final Class<Entity> entityClass) {

        this.entityClass = entityClass;
    }

    @Override
    public Entity add(final Entity entity) {

        if (entity == null || entityManager.contains(entity)) {
            return null;
        }

        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            LOGGER.error("Can not add an entity to the database", e);
            return null;
        }
        return entity;
    }

    @Override
    public boolean remove(final Long id) {

        if (id == null) {
            return false;
        }

        Entity entity = entityManager.find(entityClass, id);

        if (entity != null) {
            entityManager.remove(entity);
            return true;
        }
        return false;
    }

    @Override
    public Entity update(final Entity entity) {

        if (entity == null) {
            return null;
        }

        return entityManager.merge(entity);
    }

    @Override
    public List<Entity> findAll() {

        return entityManager.
                createQuery("from " + entityClass.getName(), entityClass).
                getResultList();
    }

    @Override
    public Entity findById(final Long id) {

        if (id == null) {
            return null;
        }

        return entityManager.find(entityClass, id);
    }

    @Override
    public List<Entity> findByQuery(final String query, final Map<String, Object> parameters) {

        if (query == null || query.isEmpty()) {
            return null;
        }

        TypedQuery<Entity> typedQuery = entityManager.createQuery(query, entityClass);

        if (parameters != null && !parameters.isEmpty()) {

            for (Map.Entry<String, Object> parameter: parameters.entrySet()) {

                typedQuery.setParameter(parameter.getKey(), parameter.getValue());
            }
        }
        return typedQuery.getResultList();
    }
}
