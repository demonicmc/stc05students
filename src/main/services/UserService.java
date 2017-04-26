package main.services;

import main.models.pojo.User;

/**
 * Created by admin on 20.04.2017.
 */
public interface UserService {
    public User auth(String login, String password);
}
