package pra.dao.impl;

import pra.bean.Users;
import pra.dao.UserDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements UserDao {

    @Override
    public List<Users> getAllUser() {

        // 给用户提供接口（京东网站、京东APP），让用户通过界面去执行 SELECT * FROM users 这条SQL语句
        // 但是这条命令，对用户来说，必须是透明的，用户并不知道后台到底发生了什么
        String sql = "SELECT * FROM users";// 用Java去执行这条SQL语句来获取数据
        String url = "jdbc:mysql://localhost:3306/test2?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        Connection conn = null;// 表示数据库的连接对象
        PreparedStatement pstmt = null;// 表示SQL语句的对象
        ResultSet rs = null;// 结果集：存储的是查询的结果，本质上讲就是一个游标，游标就是一个块内存：里面存的是查询结果

        try {
            conn = DriverManager.getConnection(url, "root", "123456");
            pstmt = conn.prepareStatement(sql);// pstmt现在就代表"SELECT * FROM users"这条SQL语句

            rs = pstmt.executeQuery();

            List<Users> usersList = new ArrayList<>();
            // 从结果集取数据，固定套路
            while (rs.next()) {// 游标向下移动一次

                int id = rs.getInt(1);
                String username = rs.getString(2);
                String password = rs.getString(3);
                String address = rs.getString(4);
                System.out.println(id + "\t" + username + "\t" + password + "\t" + address);

                Users user = new Users(id, username, password, address);
                usersList.add(user);

            }
            return usersList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        new UserDaoImpl().getAllUser();
    }
}