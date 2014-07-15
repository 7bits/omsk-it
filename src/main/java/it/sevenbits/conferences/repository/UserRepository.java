package it.sevenbits.conferences.repository;

import it.sevenbits.conferences.model.User;
import it.sevenbits.conferences.repository.exception.RepositoryException;
import it.sevenbits.conferences.repository.mapper.UserMapper;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Repository implementing all methods related to
 * User entity manipulations
 */
@Repository
public class UserRepository {

    /** Message for RepositoryException */
    private static final String REPOSITORY_USER_ID_IS_NULL_MESSAGE = "UserId is null";

    /** Logger */
    private static final Logger LOG = Logger.getLogger(UserRepository.class);

    @Autowired
    private UserMapper userMapper;


    public User findUserWithCompanyById(final Long userId) throws RepositoryException {
        LOG.info("Searching in database for user with user id:" + userId);
        if (userId == null) {
            LOG.error("Cannot lookup user with null user id in database");
            throw new RepositoryException(REPOSITORY_USER_ID_IS_NULL_MESSAGE);
        }
        return userMapper.findUserWithCompanyById(userId);
    }


    /** Returns MyBatis Database Mapper for User */
    public UserMapper getUserMapper() {
        return userMapper;
    }

    public void setUserMapper(final UserMapper userMapper) {
        this.userMapper = userMapper;
    }
}


