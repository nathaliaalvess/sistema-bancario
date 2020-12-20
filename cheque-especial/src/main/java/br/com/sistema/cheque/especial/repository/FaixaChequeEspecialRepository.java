package br.com.sistema.cheque.especial.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.sistema.cheque.especial.document.FaixaChequeEspecialDocument;

@Repository
public interface FaixaChequeEspecialRepository
    extends MongoRepository<FaixaChequeEspecialDocument, String> {

  Optional<FaixaChequeEspecialDocument> findByScore(Integer score);
}
