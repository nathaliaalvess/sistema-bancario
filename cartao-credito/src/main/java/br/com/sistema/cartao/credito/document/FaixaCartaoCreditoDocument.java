package br.com.sistema.cartao.credito.document;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "faixa_cartao_credito")
public class FaixaCartaoCreditoDocument {
  @Id private String nome;

  private List<Integer> score;

  private BigDecimal limite;
}
