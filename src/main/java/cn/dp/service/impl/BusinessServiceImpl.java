package cn.dp.service.impl;

import cn.dp.dao.UserDao;
import cn.dp.dao.impl.UserDaoXmlImpl;
import cn.dp.domain.User;
import cn.dp.exception.UserExistException;
import cn.dp.service.BusinessService;

/**
 * Created by pu on 2015/10/30 0030.
 */
public class BusinessServiceImpl implements BusinessService {
    UserDao userDao = new UserDaoXmlImpl();

    @Override
    public void regist(User user) throws UserExistException {
        if(user==null){
            throw new IllegalArgumentException("用户信息不能为空");
        }
        User dbUser = userDao.findUser(user.getUsername());
        if(dbUser!=null){
            throw new UserExistException("用户\""+user.getUsername()+"\"已经存在");
        }
        userDao.save(user);
    }

    @Override
    public User login(String username, String password) {
        return userDao.findUser(username, password);
    }
}
