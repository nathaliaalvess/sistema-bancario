package br.com.sistema.consulta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import br.com.sistema.consulta.document.CartaoCreditoDocument;

@Repository
public interface CartaoCreditoRepository extends MongoRepository<CartaoCreditoDocument, String> {
  @Query("{'conta.numero': ?0}")
  CartaoCreditoDocument findByContaNumero(String numero);
}
