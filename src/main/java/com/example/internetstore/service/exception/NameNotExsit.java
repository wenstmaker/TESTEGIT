package com.example.internetstore.service.exception;

public class NameNotExsit extends ServiceException{
    public NameNotExsit() {
        super();
    }

    public NameNotExsit(String message) {
        super(message);
    }

    public NameNotExsit(String message, Throwable cause) {
        super(message, cause);
    }

    public NameNotExsit(Throwable cause) {
        super(cause);
    }

    protected NameNotExsit(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
