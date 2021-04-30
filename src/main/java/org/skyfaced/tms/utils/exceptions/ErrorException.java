package org.skyfaced.tms.utils.exceptions;

import org.springframework.http.HttpStatus;

public class ErrorException extends Exception {
    private final String message;
    private final HttpStatus statusCode;

    public ErrorException(String message) {
        super(message);
        this.message = message;
        this.statusCode = HttpStatus.BAD_REQUEST;
    }

    public ErrorException(String message, HttpStatus statusCode) {
        super(message);
        this.message = message;
        this.statusCode = statusCode;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public HttpStatus getStatusCode() {
        return statusCode;
    }
}
