package com.example.internetstore.service.Impl;

import com.example.internetstore.Entity.User;
import com.example.internetstore.mapper.UserMapper;
import com.example.internetstore.service.UserService;
import com.example.internetstore.service.exception.InsertException;
import com.example.internetstore.service.exception.NameNotExsit;
import com.example.internetstore.service.exception.PasswordException;
import com.example.internetstore.service.exception.UsernameDuplicatedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public void reg(User user) {
        //先判断此用户名有没有被注册
        String name = user.getUsername();
        User result = userMapper.findByUsername(name);
        if(result != null){
            throw new UsernameDuplicatedException("用户名被占用");
        }
        //第一次注册，补全相应数据
        user.setIsDelete(0);
        user.setCreatedUser(user.getUsername());
        user.setModifiedUser(user.getUsername());
        Date date = new Date();
        user.setCreatedTime(date);
        user.setModifiedTime(date);
        //插入此注册数据
        Integer row = userMapper.insert(user);
        if(row != 1){
            throw new InsertException("在注册过程中产生了未知异常");
        }

    }

    @Override
    public User login(String username,String password) {
        User user = userMapper.findByUsername(username);
        if(user == null){
            throw new NameNotExsit("用户不存在");
        }
        if (user.getIsDelete() == 1) {
            // 是：抛出UserNotFoundException异常
            throw new NameNotExsit("用户数据不存在的错误");
        }
        if(!user.getPassword().equals(password))
        {
            throw new PasswordException("密码错误");
        }
        return user;
    }

    @Override
    public void UpdatePassword(String username, String OldPassword, String NewPassword) {
        User result = userMapper.findByUsername(username);
        System.out.println(username);
        System.out.println(OldPassword);
        System.out.println(NewPassword);
        if(result == null){
            throw new NameNotExsit("用户不存在");
        }
        if(!result.getPassword().equals(OldPassword)){
            throw new PasswordException("密码错误");
        }
        userMapper.UpdatePassword(username,NewPassword);
    }

    @Override
    public User getByUsername(String username) {
        User user = userMapper.findByUsername(username);
        return user;
    }

    @Override
    public User UpdatePersonMessage(String userName, String phone, String email, Integer gender) {
      User result = userMapper.findByUsername(userName);
      if(result == null || result.getIsDelete() == 1){
          throw new NameNotExsit("用户不存在");
      }
      result.setPhone(phone);
      result.setEmail(email);
      result.setGender(gender);
       userMapper.UpdatePersonMessage(result);
      User user = userMapper.findByUsername(userName);
      return user;
    }


    @Override
    public void UpdateAvatar(String name, String Avatar) {
        userMapper.UpdateAvatar(name,Avatar);
    }
}
