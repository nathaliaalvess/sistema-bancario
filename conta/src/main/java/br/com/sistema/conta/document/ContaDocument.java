package br.com.sistema.conta.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.sistema.conta.domain.TipoContaDomain;
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

  @Transient public static final String SEQUENCE_NAME = "conta_sequence";

  @Id private String numero;

  private String agencia;

  private TipoContaDomain tipo;

  private Cliente cliente;
}
