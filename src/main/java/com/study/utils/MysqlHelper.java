package main.java.com.study.utils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author ZIKOR
 * @date 2020/9/10 9:40
 * @desc
 */
public class MysqlHelper {
    //执行增、删、改   用可变参数，来接收传递过来的参数，参数的个数可以不确定，提高使用率
    public static int executeUpdate(String sql,Object...objects)
    {
        int len=0;
        PreparedStatement psta=JDBCUtil.createPreparedStatement(sql);

        try {
            for (int i = 0; i < objects.length; i++) {
                psta.setObject(i+1, objects[i]);
            }
            len=psta.executeUpdate();
            return len;
            //逐个对objects数组中的元素来进行设置 ,数组中一个元素对应一个问号
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return len;

    }
    //执行查询
    public static ResultSet executeQuery(String sql, Object...objects)
    {
        ResultSet rs=null;
        PreparedStatement psta=JDBCUtil.createPreparedStatement(sql);
        try{
            for (int i = 0; i < objects.length; i++) {
                psta.setObject(i+1, objects[i]);
            }
            rs=psta.executeQuery();
            return rs;
        }catch(SQLException e)
        {
            e.printStackTrace();
        }finally{
            //JDBCUtil.closeOperation();
        }
        return rs;

    }
}
