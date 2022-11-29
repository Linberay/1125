package cn.edu.guet.service;

import cn.edu.guet.bean.Users;

import java.util.List;

public interface UserService {
      boolean login(String username,String password);
      List<Users> getAllUser();
}
