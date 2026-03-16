package mk.ukim.finki.emc.lab.web.handler;

import mk.ukim.finki.emc.lab.model.exception.AccommodationDeletionNotAllowedException;
import mk.ukim.finki.emc.lab.model.exception.AccommodationNotAvailableException;
import mk.ukim.finki.emc.lab.model.exception.AccommodationNotFoundException;
import mk.ukim.finki.emc.lab.web.controller.AccommodationController;
import mk.ukim.finki.emc.lab.web.dto.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice(assignableTypes = AccommodationController.class)
public class AccommodationControllerExceptionHandler {
    @ExceptionHandler(AccommodationNotFoundException.class)
    public ResponseEntity<ApiError> handleNotFound(AccommodationNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(ApiError.of(HttpStatus.NOT_FOUND, exception.getMessage()));
    }

    @ExceptionHandler(AccommodationNotAvailableException.class)
    public ResponseEntity<ApiError> handleNotAvailable(AccommodationNotAvailableException exception) {
        ApiError error = new ApiError(
                HttpStatus.CONFLICT.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(AccommodationDeletionNotAllowedException.class)
    public ResponseEntity<ApiError> handleDeletionNotAllowed(AccommodationDeletionNotAllowedException exception) {
        ApiError error = new ApiError(
                HttpStatus.CONFLICT.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }
}
