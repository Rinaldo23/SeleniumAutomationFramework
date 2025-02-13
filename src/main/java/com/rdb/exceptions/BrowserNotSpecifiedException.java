package com.rdb.exceptions;

public final class BrowserNotSpecifiedException extends FrameworkException {

    public BrowserNotSpecifiedException(Throwable cause) {
        super(cause);
    }

    public BrowserNotSpecifiedException(String message) {
        super(message);
    }

    public BrowserNotSpecifiedException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
