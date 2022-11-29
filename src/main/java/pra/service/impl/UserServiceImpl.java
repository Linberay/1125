package pra.service.impl;

import pra.bean.Users;
import pra.dao.UserDao;
import pra.dao.impl.UserDaoImpl;
import pra.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {

    // 层与层之间要依赖接口
    private UserDao userDao;

    public UserServiceImpl() {
        userDao = new UserDaoImpl();// 目前是new，其实学过Spring的都知道，此处不应该new，应该从工厂拿或别人主动放到你手里
    }

    @Override
    public List<Users> getAllUser() {
        return userDao.getAllUser();
    }
}
