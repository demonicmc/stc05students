package main.models.dao;

import main.models.pojo.User;

/**
 * Created by admin on 20.04.2017.
 */
public interface UserDao {

    User findUserByLoginAndPassword(String login, String password);
}
