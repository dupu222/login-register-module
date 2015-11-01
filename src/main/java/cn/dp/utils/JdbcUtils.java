package cn.dp.utils;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class JdbcUtils {
    private static String url;
    private static String user;
    private static String password;
    private static String driveClass;

    static {
        try {
            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            Properties prop = new Properties();
            prop.load(is);
            url = prop.getProperty("url");
            user = prop.getProperty("user");
            password = prop.getProperty("password");
            driveClass = prop.getProperty("driveClass");
            Class.forName(driveClass);
        } catch (Exception e) {
            throw new ExceptionInInitializerError();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static void release(Connection conn,Statement st,ResultSet rs){
        if(rs!=null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if(st!=null){
            try {
                st.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            st = null;
        }
        if(conn!=null){
            try {
                conn.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
