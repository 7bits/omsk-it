package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.UserDao;
import it.sevenbits.conferences.domain.User;
import it.sevenbits.conferences.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDAO;

    public User getUser(String login) {
        return userDAO.getUser(login);
    }

}