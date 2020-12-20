package br.com.sistema.conta.document;

import org.springframework.data.mongodb.core.index.Indexed;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import br.com.sistema.conta.domain.TipoPessoaDomain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Cliente {

  @Indexed(unique = true)
  private String documento;

  private TipoPessoaDomain tipoPessoa;

  private Integer score;

  public boolean isPF() {
    return TipoPessoaDomain.PF.equals(tipoPessoa);
  }
}
