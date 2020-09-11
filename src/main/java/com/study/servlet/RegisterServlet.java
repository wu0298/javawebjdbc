package main.java.com.study.servlet;

import main.java.com.study.service.LoginService;
import main.java.com.study.service.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ZIKOR
 * @date 2020/9/11 16:22
 * @desc
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");


        PrintWriter out = resp.getWriter();
        String name=req.getParameter("user");
        String password=req.getParameter("passwd");
        LoginService loginService = new LoginServiceImpl();
        int flag = loginService.register(name,password);
        if(flag==1){
            out.print("<script>alert('注册成功！')</script>");
            out.print("<script>window.location='index.jsp'</script>");
        }else{
            out.print("<script>alert('注册失败！')</script>");
        }
    }
}
