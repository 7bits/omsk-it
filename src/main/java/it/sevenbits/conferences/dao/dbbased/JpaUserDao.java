package it.sevenbits.conferences.dao.dbbased;

import it.sevenbits.conferences.dao.UserDao;
import it.sevenbits.conferences.domain.User;
import org.springframework.stereotype.Repository;

/**
 * Java Persistence API based implementation of the UserDao.
 */
@Repository
public class JpaUserDao extends JpaEntityDao<User> implements UserDao {

    /**
     * Default constructor for the spring framework annotation based configuration.
     */
    public JpaUserDao() {

        super(User.class);
    }

    /**
     * Constructor from generic JpaEntityDao.
     * @param userClass generic class type.
     */
    public JpaUserDao(Class<User> userClass) {

        super(userClass);
    }
}
