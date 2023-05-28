package com.example.internetstore.Service;

import com.example.internetstore.Entity.User;
import com.example.internetstore.mapper.UserMapper;
import com.example.internetstore.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void insert(){
        User user = new User();
        user.setUsername("wu14");
        user.setPassword("123456");
        userService.reg(user);
        System.out.println("ok");
    }

    @Test
    public void login(){
//        User user = userService.find("wu");
//        System.out.println(user);
        String s1 = "wu";
        String s2 = "123456";
        userService.login(s1,s2);
        System.out.println("ok");
    }

    @Test
    public void updatePassword(){
//        User user = userService.find("wu");
//        System.out.println(user);
        String s1 = "wu";
        String s2 = "123456";
        String s3 = "123456789";
        userService.UpdatePassword(s1,s2,s3);
        System.out.println("ok");
    }

//    @Test
//    public void updatePersonMessage(){
////        User user = userService.find("wu");
////        System.out.println(user);
//        String s1 = "wu";
//        String s2 = "123456";
//        String s3 = "123456789.com";
//        User user = new User();
//        user.setPhone("1234");
//        user.setEmail("9410.qqcom");
//        user.setGender(0);
//        System.out.println(userService.UpdatePersonMessage(user));
//        System.out.println("ok");
//    }

    @Test
    public void updateAvatar(){
//        User user = userService.find("wu");
//        System.out.println(user);
        String s1 = "wu";
        String s2 = "upload/a.png";
        String s3 = "123456789";
        userService.UpdateAvatar(s1,s2);
        System.out.println("ok");
    }
}
