package com.example.internetstore.service.exception;

public class BeyongCountException extends ServiceException{
    public BeyongCountException() {
        super();
    }

    public BeyongCountException(String message) {
        super(message);
    }

    public BeyongCountException(String message, Throwable cause) {
        super(message, cause);
    }

    public BeyongCountException(Throwable cause) {
        super(cause);
    }

    protected BeyongCountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
