package it.sevenbits.conferences.service;

import it.sevenbits.conferences.domain.User;

public interface UserService {

    public User getUser(String login);
}