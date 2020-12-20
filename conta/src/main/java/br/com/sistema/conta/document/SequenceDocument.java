package br.com.sistema.conta.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Document(collection = "sequence")
public class SequenceDocument {

  @Id private String name;

  private Long value;
}
