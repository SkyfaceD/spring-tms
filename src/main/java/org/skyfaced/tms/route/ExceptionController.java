package org.skyfaced.tms.route;

import org.skyfaced.tms.model.Response;
import org.skyfaced.tms.utils.ApplicationUtils;
import org.skyfaced.tms.utils.exceptions.ErrorException;
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
