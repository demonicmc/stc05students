package main.models.dao;

import main.models.pojo.StudyGroup;

import java.util.List;

/**
 * Created by admin on 18.04.2017.
 */
public interface StudyGroupDao {
    public List<StudyGroup> getAll();
    public StudyGroup get(int id);
    public boolean update(StudyGroup student);
    public boolean delete(StudyGroup student);
}
