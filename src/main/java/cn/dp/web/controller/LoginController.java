package cn.dp.web.controller;

import cn.dp.domain.User;
import cn.dp.service.impl.BusinessServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by pu on 2015/10/30 0030.
 */
public class LoginController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String encoding = "UTF-8";
        request.setCharacterEncoding(encoding);
        response.setCharacterEncoding(encoding);
        response.setContentType("text/html;charset="+encoding);
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User user = new BusinessServiceImpl().login(username, password);
        if (user == null) {
            response.getWriter().print("用户名或者密码错误,2秒后返回");
            response.setHeader("Refresh", "2;URL=" + request.getContextPath() + "/login.jsp");
        } else {
            request.getSession().setAttribute("user", user);
            response.getWriter().write("登录成功。2秒后转向主页。");
            response.setHeader("Refresh", "2;URL=" + request.getContextPath()+"/index.jsp");
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
