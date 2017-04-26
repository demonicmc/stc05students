package main.models.pojo;

/**
 * Created by admin on 18.04.2017.
 */
public class StudyGroup {
    private Integer id;
    private String name;

    public StudyGroup(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
