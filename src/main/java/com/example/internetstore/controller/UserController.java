package com.example.internetstore.controller;

import com.example.internetstore.Entity.User;
import com.example.internetstore.controller.ex.*;
import com.example.internetstore.service.UserService;
import com.example.internetstore.service.exception.InsertException;
import com.example.internetstore.service.exception.UsernameDuplicatedException;
import com.example.internetstore.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController extends BaseController{
    @Autowired
    private UserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user){
        // 调用业务对象执行注册
        userService.reg(user);
        // 返回
        return new JsonResult<Void>(OK);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username, String password, HttpSession session){
        User user = userService.login(username,password);
        //登录成功后，将uid和username存入到HttpSession中
        session.setAttribute("uid", user.getUid());
        session.setAttribute("username", user.getUsername());
        // System.out.println("Session中的uid=" + getUidFromSession(session));
        // System.out.println("Session中的username=" + getUsernameFromSession(session));

        // 将以上返回值和状态码OK封装到响应结果中并返回
        return new JsonResult<User>(200,user);
    }

//@RequestParam:修改前后端参数不一致，前端发过来的参数是oldPassword,而我写的是OldPasword,需要对映映射
    @RequestMapping("change_password")
    public JsonResult<Void> changePassowrd(@RequestParam("oldPassword") String OldPassword, @RequestParam("newPassword") String NewPassword, HttpSession session){
        String username = getUsernameFromSession(session);
        System.out.println(OldPassword);
        System.out.println(NewPassword);
        userService.UpdatePassword(username,OldPassword,NewPassword);
        return new JsonResult<Void>(200);
    }

    @RequestMapping("get_by_uid")
    public JsonResult<User> getByUsername(HttpSession session){
        String username = getUsernameFromSession(session);
        User user = userService.getByUsername(username);
        return new JsonResult<User>(200,user);
    }

    @RequestMapping("change_info")
    public JsonResult<User> UpdatePersonMessage(User user, HttpSession session){
        String username = getUsernameFromSession(session);
        User user1 = userService.UpdatePersonMessage(username,user.getPhone(),user.getEmail(), user.getGender());
        return new JsonResult<User>(200,user1);
    }


    /** 头像文件大小的上限值(10MB) */
    public static final int AVATAR_MAX_SIZE = 10 * 1024 * 1024;
    /** 允许上传的头像的文件类型 */
    public static final List<String> AVATAR_TYPES = new ArrayList<String>();

    /** 初始化允许上传的头像的文件类型 */
    static {
        AVATAR_TYPES.add("image/jpeg");
        AVATAR_TYPES.add("image/png");
        AVATAR_TYPES.add("image/bmp");
        AVATAR_TYPES.add("image/gif");
    }


    @PostMapping("change_avatar")
    public JsonResult<String> changeAvatar(@RequestParam("file") MultipartFile file, HttpSession session) {
        // 判断上传的文件是否为空
        if (file.isEmpty()) {
            // 是：抛出异常
            throw new FileEmptyException("上传的头像文件不允许为空");
        }

        // 判断上传的文件大小是否超出限制值
        if (file.getSize() > AVATAR_MAX_SIZE) { // getSize()：返回文件的大小，以字节为单位
            // 是：抛出异常
            throw new FileSizeException("不允许上传超过" + (AVATAR_MAX_SIZE / 1024) + "KB的头像文件");
        }

        // 判断上传的文件类型是否超出限制
        String contentType = file.getContentType();
        // boolean contains(Object o)：当前列表若包含某元素，返回结果为true；若不包含该元素，返回结果为false
        if (!AVATAR_TYPES.contains(contentType)) {
            // 是：抛出异常
            throw new FileTypeException("不支持使用该类型的文件作为头像，允许的文件类型：" + AVATAR_TYPES);
        }

        // 获取当前项目的绝对磁盘路径
        String parent = session.getServletContext().getRealPath("upload");
        System.out.println(parent);
        // 保存头像文件的文件夹
        File dir = new File(parent);
        if (!dir.exists()) {
            dir.mkdirs();
        }

        // 保存的头像文件的文件名
        String suffix = "";
        String originalFilename = file.getOriginalFilename();
        int beginIndex = originalFilename.lastIndexOf(".");
        if (beginIndex > 0) {
            suffix = originalFilename.substring(beginIndex);
        }
        String filename = UUID.randomUUID().toString() + suffix;

        // 创建文件对象，表示保存的头像文件
        File dest = new File(dir, filename);
        // 执行保存头像文件
        try {
            file.transferTo(dest);
        } catch (IllegalStateException e) {
            // 抛出异常
            throw new FileStateException("文件状态异常，可能文件已被移动或删除");
        } catch (IOException e) {
            // 抛出异常
            throw new FileUploadIOException("上传文件时读写错误，请稍后重新尝试");
        }

        // 头像路径
        String avatar = "/upload/" + filename;
        // 从Session中获取uid和username
        Integer uid = getUidFromSession(session);
        String username = getUsernameFromSession(session);
        // 将头像写入到数据库中
        userService.UpdateAvatar(username, avatar);

        // 返回成功头像路径
        return new JsonResult<String>(OK, avatar);
    }


}
