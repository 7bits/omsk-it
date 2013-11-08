package it.sevenbits.conferences.dao;

import java.util.List;
import java.util.Map;

/**
 * Generic interface for an Entity model access.
 * @param <Entity> some POJO class from the domain layer.
 */
public interface EntityDao<Entity> {

    /**
     * Creates the Entity's representation in an repository.
     * @param entity an Entity which should be stored.
     * @return the Entity with generated primary key, or null in case of an error.
     */
    Entity add(final Entity entity);

    /**
     * Deletes the Entity's representation for an repository.
     * @param id Entity's primary key.
     * @return true if Entity has been removed, or false in case of an error.
     */
    boolean remove(final Long id);

    /**
     * Updates the Entity's representation in an repository.
     * @param entity the Entity with some new values.
     * @return the merged Entity, or null in case of an error.
     */
    Entity update(final Entity entity);

    /**
     * Reads all Entity's representations from an repository.
     * @return list of all stored Entities. If no Entity found - empty list will be returned.
     */
    List<Entity> findAll();

    /**
     * Reads an Entity's representation from an repository.
     * @param id Entity's primary key.
     * @return the found Entity instance, or null if the Entity does not exist or an error occurs.
     */
    Entity findById(final Long id);

    /**
     * Reads an Entity's representation from an repository.
     * @param query an String used to control query execution.
     * @param parameters the query's arguments.
     * @return the found Entities list, or null in case of an error.
     */
    List<Entity> findByQuery(final String query, final Map<String, Object> parameters);
}
