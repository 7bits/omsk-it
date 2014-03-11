package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.RoleDao;
import it.sevenbits.conferences.domain.Role;
import it.sevenbits.conferences.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

/**
 * Simple implementation of the RoleService.
 */
@Service
public class SimpleRoleService implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Transactional
    @Override
    public Role addRole(Role role) {
        return roleDao.add(role);
    }

    @Transactional
    @Override
    public boolean removeRole(Long id) {
        return roleDao.remove(id);
    }

    @Transactional
    @Override
    public Role updateRole(Role role) {
        return roleDao.update(role);
    }

    @Transactional
    @Override
    public List<Role> findAllRoles() {
        return roleDao.findAll();
    }

    @Transactional
    @Override
    public Role findRoleById(Long id) {
        return roleDao.findById(id);
    }
}
