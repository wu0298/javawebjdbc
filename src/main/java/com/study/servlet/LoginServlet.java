package main.java.com.study.servlet;

import main.java.com.study.dao.LoginDao;
import main.java.com.study.service.LoginService;
import main.java.com.study.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ZIKOR
 * @date 2020/9/10 9:20
 * @desc
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求体的字符集为utf-8，从而解决post请求中文乱码问题
        req.setCharacterEncoding("UTF-8");

        String name=req.getParameter("username");
        String password=req.getParameter("password");
        LoginService loginService = new LoginServiceImpl();
        boolean flag = loginService.login(name,password);
        if(flag){
            HttpSession session=req.getSession();
            session.setAttribute("name", name);
            session.setAttribute("password", password);
            req.getRequestDispatcher("success.jsp").forward(req,resp);
        }else{
            resp.sendRedirect("index.jsp");
        }
    }
}
