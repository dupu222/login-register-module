package cn.dp.dao.impl;

import cn.dp.dao.UserDao;
import cn.dp.domain.User;
import cn.dp.utils.JdbcUtils;

import java.sql.*;

/**
 * Created by pu on 2015/11/1 0001.
 */
public class UserDaoJdbcImpl implements UserDao {
    public void save(User user) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement("INSERT INTO users (username,password,email,birthday) VALUES (?,?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.setDate(4, new Date(user.getBirthday().getTime()));
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("初始化失败");
        } finally {
            JdbcUtils.release(conn, ps, rs);
        }
    }

    public User findUser(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement("SELECT username,password,email,birthday from users WHERE username=?");
            ps.setString(1, username);
            rs = ps.executeQuery();
            if (rs.next()){
                User user = new User();
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setBirthday(rs.getDate(4));
                return user;
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("初始化失败");
        } finally {
            JdbcUtils.release(conn, ps, rs);
        }
    }

    public User findUser(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            conn = JdbcUtils.getConnection();
            ps = conn.prepareStatement("SELECT username,password,email,birthday from users WHERE username=? AND password=?");
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            if (rs.next()){
                User user = new User();
                user.setUsername(rs.getString(1));
                user.setPassword(rs.getString(2));
                user.setEmail(rs.getString(3));
                user.setBirthday(rs.getDate(4));
                return user;
            }else{
                return null;
            }
        } catch (SQLException e) {
            throw new ExceptionInInitializerError("初始化失败");
        } finally {
            JdbcUtils.release(conn, ps, rs);
        }
    }
}
