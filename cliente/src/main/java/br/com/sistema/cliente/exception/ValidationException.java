package br.com.sistema.cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ValidationException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ValidationException(String message) {
    super(message);
    log.error(message);
  }
}
