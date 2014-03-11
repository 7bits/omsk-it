package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.Role;

import java.util.List;

/**
 * Interface for service layer, which works with EntityDao.
 * Role is the primary Entity for that Service.
 */
public interface RoleService {

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#add(Object)
     */
    Role addRole(final Role role);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#remove(Long)
     */
    boolean removeRole(final Long id);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#update(Object)
     */
    Role updateRole(final Role role);

    /**
     * Reads all users from repository.
     * @return List, witch contain all users.
     */
    List<Role> findAllRoles();

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findById(Long)
     */
    Role findRoleById(Long id);

}