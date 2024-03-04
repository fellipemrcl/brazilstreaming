package com.fellipemarcel.brazilstreaming.advice;

import com.fellipemarcel.brazilstreaming.exception.StreamingNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * The type Global exception handler.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  /**
   * Handle streaming not found exception response entity.
   *
   * @return the response entity
   */
  @ExceptionHandler({StreamingNotFoundException.class})
  public ResponseEntity<String> handleStreamingNotFoundException() {
    return ResponseEntity
        .status(HttpStatus.NOT_FOUND)
        .body("Streaming not found");
  }
}
