package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.RoleDao;
import it.sevenbits.conferences.domain.Role;
import it.sevenbits.conferences.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDAO;

    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }

}