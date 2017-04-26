package main.models.dao;

import main.models.connection.Connect;
import main.models.pojo.Student;
import main.models.pojo.User;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by admin on 20.04.2017.
 */
@Repository
public class UserDaoImpl implements UserDao {

    public User findUserByLoginAndPassword(String login, String password) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from public.user where login = ? and password = ?");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);

            ResultSet result = preparedStatement.executeQuery();

            if (result.next()) {
                return new User(
                        result.getInt("id"),
                        result.getString("login"),
                        result.getString("password"),
                        result.getBoolean("is_block")
                );
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
