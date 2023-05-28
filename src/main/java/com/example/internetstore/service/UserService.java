package com.example.internetstore.service;

import com.example.internetstore.Entity.User;

public interface UserService {

    void reg(User user);

    User login(String username,String password);

    void UpdatePassword(String username,String OldPassword,String NewPassword);

    User getByUsername(String username);

    User UpdatePersonMessage(String name,String phone,String email,Integer gender);

    void UpdateAvatar(String name,String Avatar);
}
