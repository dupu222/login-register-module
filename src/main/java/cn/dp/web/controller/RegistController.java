package cn.dp.web.controller;

import cn.dp.domain.User;
import cn.dp.exception.UserExistException;
import cn.dp.service.BusinessService;
import cn.dp.service.impl.BusinessServiceImpl;
import cn.dp.utils.UserBeanUtils;
import cn.dp.web.domain.WebUserBean;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by pu on 2015/10/30 0030.
 */
public class RegistController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoding = "UTF-8";
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
        WebUserBean webUserBean = new WebUserBean();
        webUserBean = UserBeanUtils.populate(request, webUserBean.getClass());
        //注册验证
        if(!webUserBean.validate()){
            request.setAttribute("webuserbean",webUserBean);
            request.getRequestDispatcher(request.getContextPath()+"/regist.jsp").forward(request, response);
        }

        //bean转换
        /*
        user.setUsername(webUserBean.getUsername());
        user.setPassword(webUserBean.getPassword());
        user.setEmail(webUserBean.getEmail());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            user.setBirthday(sdf.parse(webUserBean.getBirthday()));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }*/
        User user = new User();

        ConvertUtils.register(new DateLocaleConverter(), Date.class);
        try {
            BeanUtils.copyProperties(user,webUserBean);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //注册
        BusinessService bs = new BusinessServiceImpl();
        try {
            bs.regist(user);
            response.getWriter().print("注册成功,2秒后跳转");
            response.setHeader("Refresh","2;URL="+request.getContextPath()+"/index.jsp");
        } catch (UserExistException e) {
            webUserBean.getErrors().put("username","用户名已经存在");
            request.setAttribute("webuserbean",webUserBean);
            request.getRequestDispatcher(request.getContextPath()+"/regist.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
