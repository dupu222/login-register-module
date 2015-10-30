package cn.dp.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by pu on 2015/10/30 0030.
 */
public class User implements Serializable{
    private String username;
    private String password;
    private String email;
    private Date birthday;

    public User(String username, String password, String email, Date birthday) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.birthday = birthday;
    }

    public User() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
