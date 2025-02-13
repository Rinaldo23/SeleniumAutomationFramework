package com.rdb.exceptions;

public final class FileProcessingException extends FrameworkException {

    public FileProcessingException(Throwable cause) {
        super(cause);
    }

    public FileProcessingException(String message) {
        super(message);
    }

    public FileProcessingException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
