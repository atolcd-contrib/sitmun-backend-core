package org.sitmun.authorization.proxy.exception;

import io.github.resilience4j.ratelimiter.RequestNotPermitted;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RateLimiterExceptionHandler {

  @ExceptionHandler(RequestNotPermitted.class)
  public ResponseEntity<String> handleRateLimitException(RequestNotPermitted ex) {
    return ResponseEntity.status(HttpStatus.TOO_MANY_REQUESTS)
        .body("Trop de requêtes, veuillez réessayer plus tard.");
  }
}
