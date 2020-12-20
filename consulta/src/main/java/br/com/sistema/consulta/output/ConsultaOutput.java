package br.com.sistema.consulta.output;

import br.com.sistema.consulta.domain.TipoContaDomain;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConsultaOutput {
  private String numeroConta;

  private String agenciaConta;

  private TipoContaDomain tipoConta;

  private String documentoCliente;

  private CartaoCreditoOutput cartaoCredito;

  private ChequeEspecialOutput chequeEspecial;
}
