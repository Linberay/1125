package cn.edu.guet.ui;

import cn.edu.guet.bean.Users;
import cn.edu.guet.service.Impl.UserServiceImpl;
import cn.edu.guet.service.UserService;

import java.util.List;

public class UserUi {
    public static void main(String[] args) {
        UserService userService =new UserServiceImpl();

        boolean result = userService.login("zhaoqizhe","z12345");
        if (result){
            System.out.println("登陆成功，即将跳转");
            List<Users> usersList=userService.getAllUser();

            for(Users user : usersList){
                System.out.println(user);
            }
        }else{
            System.out.println("登陆失败，用户名和密码不匹配");
        }



    }
}
