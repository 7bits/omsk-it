package it.sevenbits.conferences.service.newService;

import it.sevenbits.conferences.model.User;
import it.sevenbits.conferences.repository.UserRepository;
import it.sevenbits.conferences.repository.exception.RepositoryException;
import it.sevenbits.conferences.service.exception.ServiceException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    /** Default message for ServiceException */
    private static final String SERVICE_EXCEPTION_MESSAGE = "User Service general exception. ";

    /** Logger */
    private static final Logger LOG = Logger.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    public User findUserWithCompanyById(Long userId) throws ServiceException {
        LOG.info("Searching for user with user id:" + userId);
        try {
            return userRepository.findUserWithCompanyById(userId);
        } catch (RepositoryException e) {
            LOG.error(SERVICE_EXCEPTION_MESSAGE + "Cannot find user by userId.", e);
            throw new ServiceException(SERVICE_EXCEPTION_MESSAGE, e);
        }
    }
}
