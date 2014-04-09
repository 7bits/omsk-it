package it.sevenbits.conferences.service.common;

import it.sevenbits.conferences.dao.UserDao;
import it.sevenbits.conferences.domain.User;
import it.sevenbits.conferences.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple implementation of the UserService.
 */

@Service
public class SimpleUserService implements UserService {

    /** Message for UserNotFoundException */
    private static final String USER_NOT_FOUND_EXCEPTION = "User was not found";

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public User addUser(final User user) {
        return userDao.add(user);
    }

    @Transactional
    @Override
    public boolean removeUser(final Long id) {
        return userDao.remove(id);
    }

    @Transactional
    @Override
    public User updateUser(final User user) {
        return userDao.update(user);
    }

    @Transactional
    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }

    @Transactional
    @Override
    public User findUserById(final Long id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public User findUser(final String login) throws UsernameNotFoundException{
        String query = "SELECT u FROM User u WHERE u.login =:login";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("login", login);
        List<User> usersList = userDao.findByQuery(query, queryParams);
        if (usersList == null || usersList.isEmpty()) {
            throw new UsernameNotFoundException(USER_NOT_FOUND_EXCEPTION);
        }
        return usersList.get(0);
    }

    @Transactional
    @Override
    public User findUserByEmail(final String email) {
        String query = "SELECT u FROM User u WHERE u.email =:email";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("email", email);
        List<User> usersList = userDao.findByQuery(query, queryParams);
        if (usersList == null || usersList.isEmpty()) {
            return null;
        }
        return usersList.get(0);
    }

    @Transactional
    @Override
    public User findUserByVkontakteId(final Long vkontakteId) {
        String query = "SELECT u FROM User u WHERE u.vkontakteProfile.vkontakteId =:vkontakteId";
        Map<String, Object> queryParams = new HashMap<>();
        queryParams.put("vkontakteId", vkontakteId);
        List<User> usersList = userDao.findByQuery(query, queryParams);
        if (usersList == null || usersList.isEmpty()) {
            return null;
        }
        return usersList.get(0);
    }
}