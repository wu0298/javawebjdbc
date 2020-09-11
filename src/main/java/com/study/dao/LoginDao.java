package main.java.com.study.dao;

import main.java.com.study.utils.JDBCUtil;
import main.java.com.study.utils.MysqlHelper;

import java.sql.ResultSet;

/**
 * @author ZIKOR
 * @date 2020/9/10 9:39
 * @desc
 */
public class LoginDao {
    public boolean login(String userName,String password){
        boolean b = false;
        String sql="select userName,password from User ";
        ResultSet rs= MysqlHelper.executeQuery(sql);
        try {
            while(rs.next()){               //用户输入的信息和数据库中的信息做比较，判断输入是否正确；
                String name = rs.getString("userName");
                String pwd = rs.getString("password");
                if(name.equals(userName) && pwd.equals(password)){
                    b = true;
                }
            }
            rs.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            JDBCUtil.closeOperation(rs);
        }
        return b;
    }

    public int register(String name, String password){
        String sql="insert into user values(?,?) ";
        int i=0;
        try {
            i = MysqlHelper.executeUpdate(sql,name,password);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtil.closeOperation();
        }
        return i;
    }
}
