package br.com.sistema.cartao.credito.repository;

import java.util.Optional;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.sistema.cartao.credito.document.FaixaCartaoCreditoDocument;

@Repository
public interface FaixaCartaoCreditoRepository
    extends MongoRepository<FaixaCartaoCreditoDocument, String> {

  Optional<FaixaCartaoCreditoDocument> findByScore(Integer score);
}
