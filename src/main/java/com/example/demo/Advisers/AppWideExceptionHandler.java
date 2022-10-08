package com.example.demo.Advisers;



import com.example.demo.exception.*;
import com.example.demo.util.StandardResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;

import java.lang.NullPointerException;

@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(EntryDuplicateException.class)
    public ResponseEntity<StandardResponse> handleDuplicateRequestException(EntryDuplicateException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(409, e.getMessage(), e),
                HttpStatus.CONFLICT);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<StandardResponse> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, e.getMessage(), e),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserLockedException.class)
    public ResponseEntity<StandardResponse> handleUserLockedException(UserLockedException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(423, e.getMessage(), e),
                HttpStatus.LOCKED);
    }

    @ExceptionHandler(UserNotVerifiedException.class)
    public ResponseEntity<StandardResponse> handleUserNotVerifiedException(UserNotVerifiedException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(503, e.getMessage(), e),
                HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(UserNotAcceptableException.class)
    public ResponseEntity<StandardResponse> handleUserNotAcceptableException(UserNotAcceptableException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(406, e.getMessage(), e),
                HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(RestrictedAreaException.class)
    public ResponseEntity<StandardResponse> handleUserRestrictedException(RestrictedAreaException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(405, e.getMessage(), e),
                HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(UnAuthorizedException.class)
    public ResponseEntity<StandardResponse> handleUserUnAuthorizedException(UnAuthorizedException e) {
        System.out.println("ok");
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(401, e.getMessage(), e),
                HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<StandardResponse> handleUserUnAuthorizedException(NullPointerException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(401, e.getMessage(), e),
                HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<StandardResponse> handleUserNotFoundException(UsernameNotFoundException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(404, e.getMessage(), e),
                HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(SQLIntegrityConstraintViolationException.class)
    public ResponseEntity<StandardResponse> handleSQLIntegrityConstraintViolationException(SQLIntegrityConstraintViolationException e) {
        return new ResponseEntity<StandardResponse>(
                new StandardResponse(500, e.getMessage(), e),
                HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(HttpClientErrorException.Gone.class)
    public ResponseEntity<StandardResponse> handleGoneException(HttpClientErrorException.Gone e) {
        return new ResponseEntity<StandardResponse>(new StandardResponse(410, "Error", e.getMessage()), HttpStatus.GONE);
    }



}
