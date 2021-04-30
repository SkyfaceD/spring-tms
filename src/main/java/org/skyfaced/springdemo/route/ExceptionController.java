package org.skyfaced.springdemo.route;

import org.skyfaced.springdemo.model.Response;
import org.skyfaced.springdemo.utils.ApplicationUtils;
import org.skyfaced.springdemo.utils.exceptions.ErrorException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController<T> {
    @ExceptionHandler(ErrorException.class)
    public ResponseEntity<Response<T>> errorException(ErrorException e) {
        Response<T> response = ApplicationUtils.error(e.getMessage(), null, null);
        return new ResponseEntity<>(response, e.getStatusCode());
    }
}
