package com.gilasw.notification.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoSuchCategoryFoundException extends RuntimeException {

    public NoSuchCategoryFoundException(String message) {
        super(message);
    }

    public NoSuchCategoryFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

}

