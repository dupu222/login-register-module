package cn.dp.dao;

import cn.dp.domain.User;

/**
 * Created by pu on 2015/10/30 0030.
 */
public interface UserDao {
    /**
     * 存儲用戶信息
     * @param user
     */
    void save(User user);

    /**
     * 根据用户名查找用户
     * @param username
     * @return  没有找到返回null
     */
    User findUser(String username);
    /**
     * 根据用户名和密码查找用户
     * @param username
     * @param password
     * @return  没有找到返回null
     */
    User findUser(String username,String password);
}
