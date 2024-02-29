package com.statistics.statisticsservice.hander.exception;

import org.springframework.http.HttpStatus;

public class EntityExistException extends RuntimeException {
    private HttpStatus httpStatus;

    public EntityExistException(String message) {
        super(message);
    }

}
