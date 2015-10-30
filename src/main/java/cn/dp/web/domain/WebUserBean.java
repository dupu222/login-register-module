package cn.dp.web.domain;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by pu on 2015/10/30 0030.
 */
public class WebUserBean {
    private String username;
    private String password;
    private String repassword;
    private String email;
    private String birthday;
    private Map<String, String> errors = new HashMap<String, String>();

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

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setErrors(Map<String, String> errorMap) {
        this.errors = errorMap;
    }

    public String getBirthday() {

        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Map<String, String> getErrors() {
        return errors;
    }

    public boolean validate() {
        if (username.equals("")) {
            errors.put("username", "请输入用户名");
        } else if (!username.matches("[a-zA-Z0-9]{3,8}")) {
            errors.put("username", "用户名必须由3~8位字母组成");
        }

        if (password.equals("")) {
            errors.put("password", "请输入密码");
        } else if (!password.matches("[a-zA-Z0-9]{3,8}")) {
            errors.put("password", "密码必须由3~8位字母或数字组成");
        }

        if (repassword.equals("")) {
            errors.put("repassword", "请再次输入密码");
        } else if (!repassword.equals(password)) {
            errors.put("repassword", "两次输入的密码不一样");
        }

        if (email.equals("")) {
            errors.put("email", "请输入邮箱");
        } else if (!email.matches("\\b^['_a-z0-9-\\+]+(\\.['_a-z0-9-\\+]+)*@[a-z0-9-]+(\\.[a-z0-9-]+)*\\.([a-z]{2}|aero|arpa|asia|biz|com|coop|edu|gov|info|int|jobs|mil|mobi|museum|name|nato|net|org|pro|tel|travel|xxx)$\\b")) {
            errors.put("email", "请输入正确的邮箱");
        }

        if (birthday.equals("")) {
            errors.put("birthday", "请输入出生日期");
        } else {
            try {
                new DateLocaleConverter().convert(birthday);
            } catch (Exception e) {
                errors.put("birthday", "输入的日期格式有误,日期示例:1990-01-01");
            }
        }

        return errors.isEmpty();
    }

}
