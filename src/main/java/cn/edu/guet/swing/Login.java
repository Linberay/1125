package cn.edu.guet.swing;

import cn.edu.guet.bean.Users;
import cn.edu.guet.service.Impl.UserServiceImpl;
import cn.edu.guet.service.UserService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Login {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame();// 农村建房，房子框架
        // 250*315
        jFrame.setSize(300, 315);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 点X的时候，退出程序

        // 容器
        JPanel jPanel = (JPanel) jFrame.getContentPane();
        jPanel.setLayout(null);

        JLabel usernameLabel = new JLabel("用户名：");
        usernameLabel.setBounds(15, 90, 90, 40);

        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setBounds(15, 132, 90, 40);

        JTextField usernameTextField = new JTextField();
        usernameTextField.setBounds(100, 90, 180, 40);

        JTextField passwordTextField = new JTextField();
        passwordTextField.setBounds(100, 132, 180, 40);

        JButton login = new JButton("登录");
        login.setBounds(60, 200, 90, 40);
        login.addActionListener(
                e -> {
                    String username = usernameTextField.getText();
                    String password = passwordTextField.getText();
                    System.out.println(username);
                    System.out.println(password);
                    UserService userService =new UserServiceImpl();
                    boolean result = userService.login(username,password);
                    if (result){
                        usernameTextField.setText("");
                        passwordTextField.setText("");
                        System.out.println("登陆成功，即将跳转");
                        List<Users> usersList=userService.getAllUser();

                        for(Users user : usersList){
                            System.out.println(user);
                        }
                    }else{
                        usernameTextField.setText("");
                        passwordTextField.setText("");
                        System.out.println("登陆失败，用户名和密码不匹配");
                    }


                    /*
                    1.拿到用户名和密码
                    2.把用户名和密码传入Service的login
                    3.Service的login中调用Dao的login
                    4.Dao的login真正实现登录（写JDBC代码）
                     */
                }
        );

        passwordTextField.addActionListener(
                e -> {
                        login.doClick();
                    usernameTextField.setText("");
                    passwordTextField.setText("");
                }
        );

        JButton exit = new JButton("退出");
        exit.setBounds(151, 200, 90, 40);
        exit.addActionListener(
                e -> {
                    System.exit(0);
                }
        );

        jPanel.add(usernameLabel);
        jPanel.add(usernameTextField);
        jPanel.add(passwordLabel);
        jPanel.add(passwordTextField);

        jPanel.add(login);
        jPanel.add(exit);

        jFrame.setContentPane(jPanel);

        // 输入用户名和密码的组件（好比玻璃）：JTextField
        // 登录按钮组件（玻璃）：JButton
        /*
        玻璃不能直接装到墙上（JFrame）
        门框、窗户框：容器（嵌到墙上）
         */
    }
}
