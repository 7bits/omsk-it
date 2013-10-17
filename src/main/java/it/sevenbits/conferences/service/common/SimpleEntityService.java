package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.EntityDao;
import it.sevenbits.conferences.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SimpleEntityService<Entity> implements EntityService<Entity> {

    @Autowired
    private EntityDao<Entity> entityDao;

    @Transactional
    @Override
    public Entity add(final Entity entity) {

        return entityDao.add(entity);
    }

    @Transactional
    @Override
    public boolean remove(final Long id) {

        return entityDao.remove(id);
    }

    @Transactional
    @Override
    public Entity update(final Entity entity) {

        return entityDao.update(entity);
    }

    @Transactional
    @Override
    public List<Entity> findAll() {

        return entityDao.findAll();
    }

    @Transactional
    @Override
    public Entity findById(final Long id) {

        return entityDao.findById(id);
    }

    @Transactional
    @Override
    public List<Entity> findByQuery(final String query, final Map<String, Object> parameters) {

        return entityDao.findByQuery(query, parameters);
    }
}
