package com.example.internetstore.service.exception;


//建立业务层异常的基类,根据业务层不同的功能来定义具体的异常的类型，统一的去继承ServiceException异常类
public class ServiceException extends RuntimeException{
    //重写五个异常

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    protected ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
