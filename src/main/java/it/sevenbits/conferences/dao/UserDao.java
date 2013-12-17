package it.sevenbits.conferences.dao;

import it.sevenbits.conferences.domain.User;

public interface UserDao {

    public User getUser(String login);

}