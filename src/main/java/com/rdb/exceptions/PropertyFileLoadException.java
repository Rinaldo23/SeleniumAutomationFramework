package com.rdb.exceptions;

public final class PropertyFileLoadException extends FrameworkException {
    public PropertyFileLoadException(Throwable cause) {
        super(cause);
    }

    public PropertyFileLoadException(String message) {
        super(message);
    }

    public PropertyFileLoadException(String message, Throwable cause) {
        super(message, cause);
    }

}
