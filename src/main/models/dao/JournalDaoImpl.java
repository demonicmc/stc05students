package main.models.dao;

import main.models.connection.Connect;
import main.models.pojo.Journal;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
@Repository
public class JournalDaoImpl implements JournalDao {

    public List<Journal> getAll() {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from journal");

            ResultSet result = preparedStatement.executeQuery();

            List<Journal> journalList = new ArrayList<Journal>();
            while (result.next()) {
                journalList.add(new Journal(
                        result.getInt("id"),
                        result.getInt("lesson_id"),
                        result.getInt("student_id")
                ));
            }
            return journalList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Journal get(int id) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from journal where id=?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            return new Journal(
                    result.getInt("id"),
                    result.getInt("lesson_id"),
                    result.getInt("student_id")
            );

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(Journal journal) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE journal SET(" +
                    " lesson_id, student_id)" +
                    " = (?, ?)"+
                    " WHERE id = ?");
            preparedStatement.setInt(1, journal.getLesson_id());
            preparedStatement.setInt(2, journal.getStudent_id());
            preparedStatement.setInt(3, journal.getId());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Journal journal) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from journal " +
                    " WHERE id = ?");
            preparedStatement.setInt(1, journal.getId());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
