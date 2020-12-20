package br.com.sistema.cliente.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import br.com.sistema.cliente.domain.TipoPessoaDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "cliente")
public class ClienteDocument {

  @Id private String documento;

  private String nome;

  private TipoPessoaDomain tipoPessoa;

  private Integer score;
}
