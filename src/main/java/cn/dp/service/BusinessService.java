package cn.dp.service;

import cn.dp.domain.User;
import cn.dp.exception.UserExistException;

/**
 * Created by pu on 2015/10/30 0030.
 */
public interface BusinessService {
    /**
     * 用户注册
     * @param user 注册信息
     * @throws UserExistException 如果注册用户已经存在,抛出此异常
     */
    void regist(User user)throws UserExistException;

    /**
     * 用户登录
     * @param username  用户名
     * @param password  密码
     * @return  如果用户不存在返回null
     */
    User login(String username, String password);
}
