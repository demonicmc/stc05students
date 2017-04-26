package main.models.dao;

import main.models.connection.Connect;
import main.models.pojo.Lesson;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
@Repository
public class LessonDaoImpl implements LessonDao {
    public List<Lesson> getAll() {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from lesson");

            ResultSet result = preparedStatement.executeQuery();

            List<Lesson> lessonList = new ArrayList<Lesson>();
            while (result.next()) {
                lessonList.add(new Lesson(
                        result.getInt("id"),
                        result.getInt("study_group_id"),
                        result.getDate("lesson_date"),
                        result.getInt("room"),
                        result.getString("description")
                ));
            }
            return lessonList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Lesson get(int id) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from lesson where id=?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            return new Lesson(
                    result.getInt("id"),
                    result.getInt("study_group_id"),
                    result.getDate("lesson_date"),
                    result.getInt("room"),
                    result.getString("description")
            );

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(Lesson lesson) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE lesson SET(" +
                    " study_group_id, lesson_date, room, description)" +
                    " = (?, ?, ?, ?)"+
                    " WHERE id = ?");
            preparedStatement.setInt(1, lesson.getStudy_group_id());
            preparedStatement.setDate(2, (Date) lesson.getLesson_date());
            preparedStatement.setInt(3, lesson.getRoom());
            preparedStatement.setString(4, lesson.getDescription());
            preparedStatement.setInt(5, lesson.getId());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Lesson lesson) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from lesson " +
                    " WHERE id = ?");
            preparedStatement.setInt(1, lesson.getId());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }


}
