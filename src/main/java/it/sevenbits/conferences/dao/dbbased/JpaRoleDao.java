package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.RoleDao;
import it.sevenbits.conferences.domain.Role;
import org.springframework.stereotype.Repository;

/**
 * Java Persistence API based implementation of the RoleDao.
 */
@Repository
public class JpaRoleDao extends JpaEntityDao<Role> implements RoleDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaRoleDao() {

        super(Role.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param roleClass generic class type.
     */
    public JpaRoleDao(Class<Role> roleClass) {

        super(roleClass);
    }
}
