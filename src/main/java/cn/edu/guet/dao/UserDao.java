package cn.edu.guet.dao;

import cn.edu.guet.bean.Users;

import java.util.List;

public interface UserDao {
    boolean login(String username,String password);
    List<Users> getAllUser();
}
