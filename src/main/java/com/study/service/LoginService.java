package main.java.com.study.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author ZIKOR
 * @date 2020/9/10 11:03
 * @desc
 */
public interface LoginService {
    public boolean login(String name,String password);
}
