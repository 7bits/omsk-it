package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.EntityDao;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Map;

@Repository
public class JpaEntityDao<Entity> implements EntityDao<Entity> {

    @PersistenceContext
    private EntityManager entityManager;

    private Class<Entity> clazz;

    @Override
    public Entity add(Entity entity) {

        entityManager.persist(entity);
        return entity;
    }

    @Override
    public boolean remove(final Long id) {

        Entity entity = entityManager.find(clazz, id);

        if (entity != null) {
            entityManager.remove(entity);
            return true;
        }
        return false;
    }

    @Override
    public Entity update(final Entity entity) {

        return entityManager.merge(entity);
    }

    @Override
    public List<Entity> findAll() {

        return entityManager.
                createQuery("from " + clazz.getName().toLowerCase(), clazz).
                getResultList();
    }

    @Override
    public Entity findById(final Long id) {

        return entityManager.find(clazz, id);
    }

    @Override
    public List<Entity> findByQuery(final String query, final Map<String, Object> parameters) {

        TypedQuery<Entity> typedQuery = entityManager.createQuery(query, clazz);

        for (Map.Entry<String, Object> parameter: parameters.entrySet()) {

            typedQuery.setParameter(parameter.getKey(), parameter.getValue());
        }
        return typedQuery.getResultList();
    }
}
