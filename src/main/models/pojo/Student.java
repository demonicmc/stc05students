package main.models.pojo;

/**
 * Created by admin on 18.04.2017.
 */
public class Student {

    private Integer id;
    private String name;
    private Integer group_id;
    private Integer age;

    public Student(Integer id, String name, Integer group_id, Integer age) {
        this.id = id;
        this.name = name;
        this.group_id = group_id;
        this.age = age;
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

    public Integer getGroup_id() {
        return group_id;
    }

    public void setGroup_id(Integer group_id) {
        this.group_id = group_id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
