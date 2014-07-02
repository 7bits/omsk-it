package it.sevenbits.conferences.service;

import java.util.List;

import it.sevenbits.conferences.domain.User;

/**
 * Interface for service layer, which works with EntityDao.
 * User is the primary Entity for that Service.
 */
public interface UserService {

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#add(Object)
     */
    User addUser(final User user);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#remove(Long)
     */
    boolean removeUser(final Long id);

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#update(Object)
     */
    User updateUser(final User user);

    /**
     * Reads all users from repository.
     * @return List, witch contain all users.
     */
    List<User> findAllUsers();

    /**
     * @see it.sevenbits.conferences.dao.EntityDao#findById(Long)
     */
    User findUserById(Long id);

    /**
     * Find the user with the necessary login.
     * @param login User's login information.
     * @return User which correspond to login or null otherwise.
     */
    User findUser(final String login);

    /**
     * Find the user with the necessary email.
     * @param email User's login information.
     * @return User which correspond to login or null otherwise.
     */
    User findUserByEmail(final String email);

    /**
     * Find the user witch has vkontakte's profile/
     * @param vkontakteId User's vkontakte's profile id
     * @return User with vkontakteId or null otherwise.
     */
    User findUserByVkontakteId(final Long vkontakteId);
}
