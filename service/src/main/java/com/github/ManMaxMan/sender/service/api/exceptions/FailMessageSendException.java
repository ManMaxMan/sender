package com.github.ManMaxMan.sender.service.api.exceptions;

public class FailMessageSendException extends Exception{
    public FailMessageSendException() {
    }

    public FailMessageSendException(String message) {
        super(message);
    }

    public FailMessageSendException(String message, Throwable cause) {
        super(message, cause);
    }

    public FailMessageSendException(Throwable cause) {
        super(cause);
    }

    public FailMessageSendException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
