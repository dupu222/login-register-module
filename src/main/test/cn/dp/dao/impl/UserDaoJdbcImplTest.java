package cn.dp.dao.impl;

import cn.dp.domain.User;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by pu on 2015/11/1 0001.
 */
public class UserDaoJdbcImplTest {
    User user;
    UserDaoJdbcImpl userDaoJdbc;
    @Before
    public void setUp() throws Exception {
        user = new User("nima","caonima","caonimaa@123.com", new Date());
        userDaoJdbc = new UserDaoJdbcImpl();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSave() throws Exception {
        userDaoJdbc.save(user);
    }

    @Test
    public void testFindUser() throws Exception {
        User u = userDaoJdbc.findUser("nima");
        Assert.assertEquals(user.getPassword(),u.getPassword());
    }

    @Test
    public void testFindUser1() throws Exception {
        User u = userDaoJdbc.findUser("nima");
        Assert.assertEquals(user.getPassword(),u.getPassword());
    }
}