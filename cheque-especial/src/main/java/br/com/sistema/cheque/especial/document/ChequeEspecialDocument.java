package br.com.sistema.cheque.especial.document;

import java.math.BigDecimal;
import org.bson.types.ObjectId;
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
@Document(collection = "cheque_especial")
public class ChequeEspecialDocument {

  @Id private ObjectId id;

  private Conta conta;

  private BigDecimal limite;
}
