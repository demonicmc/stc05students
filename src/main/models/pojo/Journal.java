package main.models.pojo;

/**
 * Created by admin on 18.04.2017.
 */
public class Journal {
    private Integer id;
    private Integer student_id;
    private Integer lesson_id;

    public Journal(Integer id, Integer student_id, Integer lesson_id) {
        this.id = id;
        this.student_id = student_id;
        this.lesson_id = lesson_id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public Integer getLesson_id() {
        return lesson_id;
    }

    public void setLesson_id(Integer lesson_id) {
        this.lesson_id = lesson_id;
    }
}
