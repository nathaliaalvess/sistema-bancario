package br.com.sistema.cartao.credito.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.sistema.cartao.credito.document.CartaoCreditoDocument;

@Repository
public interface CartaoCreditoRepository extends MongoRepository<CartaoCreditoDocument, String> {}
