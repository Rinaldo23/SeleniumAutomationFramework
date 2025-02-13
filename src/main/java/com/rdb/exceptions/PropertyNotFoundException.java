package com.rdb.exceptions;

public final class PropertyNotFoundException extends FrameworkException {
    public PropertyNotFoundException(Throwable cause) {
        super(cause);
    }

    public PropertyNotFoundException(String message) {
        super(message);
    }

    public PropertyNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
