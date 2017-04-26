package main.models.dao;

import main.models.connection.Connect;
import main.models.pojo.StudyGroup;
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
public class StudyGroupDaoImpl implements StudyGroupDao {
    public List<StudyGroup> getAll() {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from study_group");

            ResultSet result = preparedStatement.executeQuery();

            List<StudyGroup> studyGroupList = new ArrayList<StudyGroup>();
            while (result.next()) {
                studyGroupList.add(new StudyGroup(
                        result.getInt("id"),
                        result.getString("name")
                ));
            }
            return studyGroupList;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public StudyGroup get(int id) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select *"+
                    " from study_group where id=?");
            preparedStatement.setInt(1, id);

            ResultSet result = preparedStatement.executeQuery();

            result.next();
            return new StudyGroup(
                    result.getInt("id"),
                    result.getString("name")
            );

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean update(StudyGroup studyGroup) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE study_group " +
                    " SET name = ? WHERE id = ?");
            preparedStatement.setString(1, studyGroup.getName());
            preparedStatement.setInt(2, studyGroup.getId());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(StudyGroup studyGroup) {
        Connection connection = Connect.initConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("Delete from study_group " +
                    " WHERE id = ?");
            preparedStatement.setInt(1, studyGroup.getId());
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
