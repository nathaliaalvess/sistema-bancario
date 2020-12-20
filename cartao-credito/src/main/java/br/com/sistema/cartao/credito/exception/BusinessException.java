package br.com.sistema.cartao.credito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class BusinessException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public BusinessException(String message) {
    super(message);
    log.warn(message);
  }
}
