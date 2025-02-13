package com.rdb.exceptions;

public final class ExcelFileNotFoundException extends FrameworkException {

    public ExcelFileNotFoundException(Throwable cause) {
        super(cause);
    }

    public ExcelFileNotFoundException(String message) {
        super(message);
    }

    public ExcelFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
