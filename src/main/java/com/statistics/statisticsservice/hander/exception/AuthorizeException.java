package com.statistics.statisticsservice.hander.exception;

import org.springframework.http.HttpStatus;

import java.util.Objects;

public class AuthorizeException extends RuntimeException {
    private HttpStatus httpStatus;

    public AuthorizeException(String message) {
        super(message);
    }

    public AuthorizeException(HttpStatus httpStatus) {
        super();
        this.httpStatus = httpStatus;
    }

    public AuthorizeException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }

    @Override
    public String toString() {
        return "AuthorizeException{" +
                "message='" + super.getMessage() + '\'' +
                ", httpStatus=" + httpStatus +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AuthorizeException that = (AuthorizeException) o;
        return httpStatus == that.httpStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(httpStatus);
    }
}
