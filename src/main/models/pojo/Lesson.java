package main.models.pojo;

import java.util.Date;

/**
 * Created by admin on 18.04.2017.
 */
public class Lesson {
    private Integer id;
    private Integer study_group_id;
    private Date lesson_date;
    private Integer room;
    private String description;

    public Lesson(Integer id, Integer study_group_id, Date lesson_date, Integer room, String description) {
        this.id = id;
        this.study_group_id = study_group_id;
        this.lesson_date = lesson_date;
        this.room = room;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudy_group_id() {
        return study_group_id;
    }

    public void setStudy_group_id(Integer study_group_id) {
        this.study_group_id = study_group_id;
    }

    public Date getLesson_date() {
        return lesson_date;
    }

    public void setLesson_date(Date lesson_date) {
        this.lesson_date = lesson_date;
    }

    public Integer getRoom() {
        return room;
    }

    public void setRoom(Integer room) {
        this.room = room;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
