package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.RoleDao;
import it.sevenbits.conferences.domain.Role;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleDaoImpl implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Role getRole(int id) {
        Role role = (Role) entityManager.find(Role.class, id);
        //Role role = (Role) getCurrentSession().load(Role.class, id);
        return role;
    }

}