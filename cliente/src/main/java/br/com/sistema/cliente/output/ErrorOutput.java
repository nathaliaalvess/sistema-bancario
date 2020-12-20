package br.com.sistema.cliente.output;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorOutput {
  private String message;
  private int code;
  private String status;
}
