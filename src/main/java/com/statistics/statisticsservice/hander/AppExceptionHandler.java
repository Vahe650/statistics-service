package com.statistics.statisticsservice.hander;

import com.statistics.statisticsservice.hander.exception.AuthorizeException;
import com.statistics.statisticsservice.hander.exception.EntityExistException;
import com.statistics.statisticsservice.hander.exception.EntityNotFoundException;
import com.statistics.statisticsservice.hander.exception.ExceptionMessage;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.net.ConnectException;
import java.time.LocalDateTime;

@RestControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(EntityNotFoundException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                LocalDateTime.now(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(exceptionMessage, httpStatus);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(EntityExistException.class)
    public ResponseEntity<Object> handleEntityExistException(EntityExistException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.CONFLICT;
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                LocalDateTime.now(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(exceptionMessage, httpStatus);
    }

    @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
    @ExceptionHandler(ConnectException.class)
    public ResponseEntity<Object> handleApiConnectException(ConnectException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.SERVICE_UNAVAILABLE;
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                LocalDateTime.now(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(exceptionMessage, httpStatus);
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(AuthorizeException.class)
    public ResponseEntity<Object> handleUnauthorized(AuthorizeException e, HttpServletRequest request) {
        HttpStatus httpStatus = HttpStatus.UNAUTHORIZED;
        ExceptionMessage exceptionMessage = new ExceptionMessage(
                LocalDateTime.now(),
                httpStatus.value(),
                httpStatus.getReasonPhrase(),
                e.getMessage(),
                request.getRequestURI()
        );
        return new ResponseEntity<>(exceptionMessage, httpStatus);
    }
}
