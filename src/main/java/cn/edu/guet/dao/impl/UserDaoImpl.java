package cn.edu.guet.dao.impl;

import cn.edu.guet.bean.Users;
import cn.edu.guet.dao.UserDao;
import cn.edu.guet.md5.PasswordEncoder;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    public boolean login(String username, String password) {
        String sql = "SELECT password FROM users where username='"+username+"'";
        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Connection conn = null;
        PreparedStatement pstmt = null;//表示SQL语句的对象
        ResultSet rs = null;
        boolean zhen = false;
        try {
            conn = DriverManager.getConnection(url, "root", "123456");
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            PasswordEncoder encoderMd5 = new PasswordEncoder("6e9e4676d01c434da03d1aaf45c7413e", "MD5");
            String zpassword = encoderMd5.encode(password);


            while(rs.next()){
                String password1 = rs.getString("password");
                if (password1.equals(zpassword)) {
                    zhen= true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zhen;
    }/*
        else{
           throw new UserException("用户名或密码错误");//制造异常
        }
        */

    @Override
    public List<Users> getAllUser() {
        String sql = "SELECT * FROM users";
        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Connection conn = null;
        PreparedStatement pstmt = null;//表示SQL语句的对象
        ResultSet rs = null;
        try {
            conn = DriverManager.getConnection(url, "root", "123456");
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            List<Users> usersList =new ArrayList<Users>();
            //从结果集取数据
            while (rs.next()) {

                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String addtress = rs.getString(4);
                //System.out.println(id + "\t" + username + "\t" + password + "\t" + addtress);
                Users user =new Users(id,username,password,addtress);
                usersList.add(user);
            }
            return usersList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

        public static void main (String[]args){
        new UserDaoImpl().login("zhaoqizhe","z12345");
          //  new UserDaoImpl().getAllUser();
        }

}
