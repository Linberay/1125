package cn.edu.guet.service.Impl;

import cn.edu.guet.bean.Users;
import cn.edu.guet.dao.UserDao;
import cn.edu.guet.dao.impl.UserDaoImpl;
import cn.edu.guet.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao;

    public UserServiceImpl() {
        userDao=new UserDaoImpl();
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.login(username,password);
    }

    @Override
    public List<Users> getAllUser() {
        return userDao.getAllUser();
    }
}
