package br.com.sistema.cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class DuplicateException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public DuplicateException(String message) {
    super(message);
    log.error(message);
  }
}
