package br.com.sistema.consulta.output;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CartaoCreditoOutput {

  private String numero;

  private BigDecimal limite;
}
