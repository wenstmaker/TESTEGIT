package com.example.internetstore.controller;


import com.example.internetstore.controller.ex.*;
import com.example.internetstore.service.exception.*;
import com.example.internetstore.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpSession;

/** 控制器类的基类 */
public class BaseController {
    /** 操作成功的状态码 */
    public static final int OK = 200;

    /**
     * 从HttpSession对象中获取uid
     * @param session HttpSession对象
     * @return 当前登录的用户的id
     */
    protected final Integer getUidFromSession(HttpSession session) {
        return Integer.valueOf(session.getAttribute("uid").toString());
    }

    /**
     * 从HttpSession对象中获取用户名
     * @param session HttpSession对象
     * @return 当前登录的用户名
     */
    protected final String getUsernameFromSession(HttpSession session) {
        return session.getAttribute("username").toString();
    }

    /** @ExceptionHandler用于统一处理方法抛出的异常 */
    @ExceptionHandler({ServiceException.class, FileUploadException.class})
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof UsernameDuplicatedException) {
            result.setState(4000);
        }else if (e instanceof InsertException) {
            result.setState(5000);
        }else if (e instanceof NameNotExsit) {
            result.setState(4001);
        } else if (e instanceof PasswordException) {
            result.setState(4002);
        }else if (e instanceof FileEmptyException) {
            result.setState(6000);
        } else if (e instanceof FileSizeException) {
            result.setState(6001);
        } else if (e instanceof FileTypeException) {
            result.setState(6002);
        } else if (e instanceof FileStateException) {
            result.setState(6003);
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
        }

        return result;
    }
}
