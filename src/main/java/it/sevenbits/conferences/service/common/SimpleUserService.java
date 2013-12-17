package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.UserDao;
import it.sevenbits.conferences.domain.User;
import it.sevenbits.conferences.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleUserService implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User addUser(User user) {
        return userDao.add(user);
    }

    @Transactional
    @Override
    public boolean removeUser(Long id) {
        return userDao.remove(id);
    }

    @Transactional
    @Override
    public User updateUser(User user) {
        return userDao.update(user);
    }

    @Transactional
    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public User findById(Long id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User getUser(final String login) {
        String query = "SELECT u FROM User u WHERE u.login =:login";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("login", login);
        List<User> usersList = userDao.findByQuery(query,queryParams);
        if (usersList == null || usersList.isEmpty()) {
            return null;
        }
        return usersList.get(0);
    }

}