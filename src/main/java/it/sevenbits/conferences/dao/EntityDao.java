package it.sevenbits.conferences.dao;

import java.util.List;
import java.util.Map;

public interface EntityDao<Entity> {

    Entity add(final Entity entity);

    boolean remove(final Long id);

    Entity update(final Entity entity);

    List<Entity> findAll();

    Entity findById(final Long id);

    List<Entity> findByQuery(final String query, final Map<String, Object> parameters);
}
