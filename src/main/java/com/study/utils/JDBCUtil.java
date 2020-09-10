package main.java.com.study.utils;

import java.sql.*;

/**
 * @author ZIKOR
 * @date 2020/9/10 9:30
 * @desc
 */
public class JDBCUtil {
    private static String DBDriver="com.mysql.cj.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/task-first?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT%2B8&useSSL=false";
    private static String user="root";
    private static String password="123456";
    static Connection con=null;
    static Statement sta=null;
    static PreparedStatement psta=null;
    //获得数据库的链接
    public static Connection getConnection()
    {
        try {
            Class.forName(DBDriver);
            try {
                con = DriverManager.getConnection(url, user, password);
                return con;
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }

        return null;
    }
    public static Statement createStatement()
    {
        try {
            sta=getConnection().createStatement();
            return sta;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    //创造数据预处理对象
    public static PreparedStatement createPreparedStatement(String sql)
    {
        try {
            psta = getConnection().prepareStatement(sql);
            return psta;
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return psta;
    }
    //关闭所有打开的资源
    public static void closeOperation()
    {
        if(psta==null)
        {
            try {
                psta.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(sta==null)
        {
            try {
                sta.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(con==null)
        {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }

    public static void closeOperation(ResultSet rs)
    {
        if (rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(psta!=null)
        {
            try {
                psta.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(sta!=null)
        {
            try {
                sta.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if(con!=null)
        {
            try {
                con.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

    }
}
