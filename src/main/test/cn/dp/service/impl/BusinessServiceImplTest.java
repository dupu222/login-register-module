package cn.dp.service.impl;

import cn.dp.domain.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

/**
 * Created by pu on 2015/11/1 0001.
 */
public class BusinessServiceImplTest {

    BusinessServiceImpl bs = null;
    User user = null;
    @Before
    public void before() throws Exception{
        bs = new BusinessServiceImpl();
        user = new User("fuck u","123","321@321.com", new Date());
    }
    @Test
    public void testRegist() throws Exception {
        bs.regist(user);
    }

    @Test
    public void testLogin() throws Exception {
        User u = bs.login("nima", "caonima");
        Assert.assertEquals(u.getEmail(),user.getEmail());
    }
}