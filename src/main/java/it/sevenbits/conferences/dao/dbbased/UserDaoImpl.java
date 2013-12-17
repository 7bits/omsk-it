package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.UserDao;
import it.sevenbits.conferences.domain.User;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    public User getUser(String login) {
        List<User> userList;
        Query query = entityManager.createQuery("SELECT u FROM User u where u.login = :login", User.class);
        query.setParameter("login", login);
        userList = query.getResultList();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;
    }

}