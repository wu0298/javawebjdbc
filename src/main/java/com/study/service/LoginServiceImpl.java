package main.java.com.study.service;

import main.java.com.study.dao.LoginDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author ZIKOR
 * @date 2020/9/10 11:04
 * @desc
 */
public class LoginServiceImpl implements LoginService {
    @Override
    public boolean login(String name,String password) {
        LoginDao loginDao = new LoginDao();
        boolean flag=loginDao.login(name, password);
        return flag;
    }

    @Override
    public int register(String name, String password) {
        LoginDao loginDao = new LoginDao();
        int i = loginDao.register(name,password);
        return i;
    }
}
