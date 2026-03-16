package mk.ukim.finki.emc.lab.web.handler;

import mk.ukim.finki.emc.lab.model.exception.CountryNotFoundException;
import mk.ukim.finki.emc.lab.model.exception.HostNotFoundException;
import mk.ukim.finki.emc.lab.web.controller.CountryController;
import mk.ukim.finki.emc.lab.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(assignableTypes = CountryController.class)
public class CountryControllerExceptionHandler {
    @ExceptionHandler(HostNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(CountryNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }
}
