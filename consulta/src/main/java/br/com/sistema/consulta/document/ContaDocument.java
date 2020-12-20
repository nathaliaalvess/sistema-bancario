package br.com.sistema.consulta.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.sistema.consulta.domain.TipoContaDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "conta")
public class ContaDocument {

  @Id private String numero;

  private String agencia;

  private TipoContaDomain tipo;

  private Cliente cliente;
}
