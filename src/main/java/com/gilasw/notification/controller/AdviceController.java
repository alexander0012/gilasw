package com.gilasw.notification.controller;

import com.gilasw.notification.controller.dto.ErrorResponse;
import com.gilasw.notification.exception.MessageEmptyException;
import com.gilasw.notification.exception.NoSuchCategoryFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AdviceController {

    private static final String ERROR_MESSAGE = "There was an error: ";

    @ExceptionHandler(value = {NoSuchCategoryFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse badRequest(NoSuchCategoryFoundException e) {
        log.error(ERROR_MESSAGE, e);
        return ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .errorDetails(e.getMessage())
                .build();
    }

    @ExceptionHandler(value = {MessageEmptyException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse badRequest(MessageEmptyException e) {
        log.error(ERROR_MESSAGE, e);
        return ErrorResponse.builder()
                .message(e.getMessage())
                .status(HttpStatus.NOT_FOUND.value())
                .errorDetails(e.getMessage())
                .build();
    }
}
