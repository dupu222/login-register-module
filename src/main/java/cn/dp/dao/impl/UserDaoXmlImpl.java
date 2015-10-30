package cn.dp.dao.impl;

import cn.dp.dao.UserDao;
import cn.dp.domain.User;
import cn.dp.utils.Dom4jUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by pu on 2015/10/30 0030.
 */
public class UserDaoXmlImpl implements UserDao {
    @Override
    public void save(User user) {
        try {
            Document document = Dom4jUtils.getDocument();
            Element root = document.getRootElement();
            root.addElement("user")
                    .addAttribute("username", user.getUsername())
                    .addAttribute("password", user.getPassword())
                    .addAttribute("email", user.getEmail())
                    .addAttribute("birthday", user.getBirthday().toLocaleString());
            Dom4jUtils.write2xml(document);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUser(String username) {
        try {
            Document document = Dom4jUtils.getDocument();
            Node node = document.selectSingleNode("//user[@username='"+username+"']");
            if(node==null){
                return null;
            }
            User user = new User();
            user.setUsername(node.valueOf("@username"));
            user.setPassword(node.valueOf("@password"));
            user.setEmail(node.valueOf("@email"));
            Date birthday = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            birthday = sdf.parse(node.valueOf("@birthday"));
            user.setBirthday(birthday);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User findUser(String username, String password) {
        try {
            Document document = Dom4jUtils.getDocument();
            Node node = document.selectSingleNode("//user[@username='"+username+"' and @password='"+password+"']");
            if(node==null){
                return null;
            }
            User user = new User();
            user.setUsername(node.valueOf("@username"));
            user.setPassword(node.valueOf("@password"));
            user.setEmail(node.valueOf("@email"));
            Date birthday = null;
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            birthday = sdf.parse(node.valueOf("@birthday"));
            user.setBirthday(birthday);
            return user;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
