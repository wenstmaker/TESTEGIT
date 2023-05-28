package com.example.internetstore.mapper;

import com.example.internetstore.Entity.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     *
     * @return 返回影响的行数
     */
    Integer insert(User user);

    /**
     *
     * @param username  根据name查询当前用户
     * @return 返回用户信息
     */
    User findByUsername(String username);


    //@Param：当与dao层映射参数超过1个，就必须用此注解，来表示映射到sql语句中的对应名称，比如，password相当于别名为pd，映射到SQL中的pd
    Integer UpdatePassword(@Param("username")String username, @Param("pd")String password);

//    Integer UpdatePersonMessage(@Param("username")String username,@Param("phone")String phone,
//                             @Param("email")String email,@Param("gender")Integer gender);
        Integer UpdatePersonMessage(User use);


        Integer UpdateAvatar(@Param("username")String username, @Param("avatar")String avatar);


}