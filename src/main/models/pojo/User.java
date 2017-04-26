package main.models.pojo;

/**
 * Created by admin on 20.04.2017.
 */
public class User {
    private long id;
    private String login;
    private String password;
    private boolean is_block;

    public User(long id, String login, String password, boolean is_block) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.is_block = is_block;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isIs_block() {
        return is_block;
    }

    public void setIs_block(boolean is_block) {
        this.is_block = is_block;
    }
}
