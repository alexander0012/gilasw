package com.gilasw.notification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class MessageEmptyException extends RuntimeException {

    public MessageEmptyException(String message) {
        super(message);
    }

    public MessageEmptyException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

