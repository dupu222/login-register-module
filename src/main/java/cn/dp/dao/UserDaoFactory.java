package cn.dp.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by pu on 2015/11/1 0001.
 */
public class UserDaoFactory {
    private static String classname;

    static {
        InputStream in = UserDaoFactory.class.getClassLoader().getResourceAsStream("dao.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            classname = prop.getProperty("daoimpl");
            in.close();
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
    public static UserDao getUserDao(){
        try {
            return (UserDao) Class.forName(classname).newInstance();
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
