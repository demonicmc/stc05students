package main.services;

import main.models.dao.UserDao;
import main.models.pojo.User;
import main.utils.Benchmark;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by admin on 20.04.2017.
 */
@Service
public class UserServiceImpl implements UserService {

    @Benchmark
    private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
    private UserDao userDAO;

    public UserDao getUserDAO() {
        return userDAO;
    }

    public void setUserDAO(UserDao userDAO) {
        this.userDAO = userDAO;
    }

    public User auth(String login, String password) {
        User user = userDAO.findUserByLoginAndPassword(login, password);

        logger.debug("user: " + user);

        if (user != null && user.isIs_block()) {
            return null;
        }
        logger.debug("user not blocked");

        return user;
    }
}
