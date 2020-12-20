package br.com.sistema.conta.repository;

import static org.springframework.data.mongodb.core.query.Criteria.where;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import br.com.sistema.conta.document.SequenceDocument;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class SequenceRepositoryImp {
  private final MongoTemplate template;

  public Long buscarValorSequence(String name) {
    Query query = new Query();
    query.addCriteria(where("name").is(name));

    return template
        .findAndModify(
            query,
            new Update().inc("value", 1),
            FindAndModifyOptions.options().returnNew(true).upsert(true),
            SequenceDocument.class)
        .getValue();
  }
}
