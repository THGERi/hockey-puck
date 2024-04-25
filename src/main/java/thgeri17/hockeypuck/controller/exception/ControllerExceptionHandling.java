package thgeri17.hockeypuck.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import thgeri17.hockeypuck.value.ErrorCode;

import java.util.Map;
import java.util.NoSuchElementException;

import static thgeri17.hockeypuck.value.ErrorCode.NOT_FOUND;

@ControllerAdvice

public class ControllerExceptionHandling {

    @ExceptionHandler(value = {NoSuchElementException.class})
    public ResponseEntity<Object> handleNoSuchElementException(NoSuchElementException ex) {
        return new ResponseEntity<>(responseBodyWithMessage(NOT_FOUND, ex.getMessage()),HttpStatus.NOT_FOUND);

    }

    private String responseBodyWithMessage(ErrorCode code, String message) {
        return Map.of(code, message).toString();
    }
}
