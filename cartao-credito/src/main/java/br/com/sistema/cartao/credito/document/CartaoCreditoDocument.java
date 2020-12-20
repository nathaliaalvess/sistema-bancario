package br.com.sistema.cartao.credito.document;

import java.math.BigDecimal;
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
@Document(collection = "cartao_credito")
public class CartaoCreditoDocument {

  @Id private String numero;

  private Conta conta;

  private BigDecimal limite;
}
