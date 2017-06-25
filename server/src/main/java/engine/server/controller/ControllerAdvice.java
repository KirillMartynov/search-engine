package engine.server.controller;

import engine.server.exception.InvalidQueryException;
import engine.server.response.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ControllerAdvice.class);

    @ExceptionHandler(InvalidQueryException.class)
    public ResponseEntity<ErrorResponse> handleInvalidQueryException(InvalidQueryException ex) {
        logger.error(ex.getMessage(), ex);

        return ResponseEntity.status(600)
                .body(new ErrorResponse("invalid_query"));
    }
}
