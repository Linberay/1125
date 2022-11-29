package pra.ui;



import pra.bean.Users;
import pra.service.UserService;
import pra.service.impl.UserServiceImpl;

import java.util.List;


public class Test {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        List<Users> usersList = userService.getAllUser();

        for(Users user : usersList){
            System.out.println(user);
        }

    }
}