package br.com.sistema.cliente.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import br.com.sistema.cliente.exception.DuplicateException;
import br.com.sistema.cliente.exception.ParseException;
import br.com.sistema.cliente.exception.ValidationException;
import br.com.sistema.cliente.output.ErrorOutput;

@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler({DuplicateException.class, ParseException.class, ValidationException.class})
  protected ResponseEntity<Object> handleCustonException(
      RuntimeException exception, WebRequest request) {

    HttpStatus httpStatus = getHttpStatus(exception);

    ErrorOutput error =
        ErrorOutput.builder()
            .message(exception.getMessage())
            .status(httpStatus.name())
            .code(httpStatus.value())
            .build();

    return new ResponseEntity<>(error, httpStatus);
  }

  private HttpStatus getHttpStatus(RuntimeException exception) {
    ResponseStatus responseStatus = exception.getClass().getAnnotation(ResponseStatus.class);
    if (responseStatus != null) {
      return responseStatus.value();
    }
    return HttpStatus.INTERNAL_SERVER_ERROR;
  }
}
