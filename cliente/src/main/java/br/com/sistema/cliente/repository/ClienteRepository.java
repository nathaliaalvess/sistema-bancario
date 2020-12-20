package br.com.sistema.cliente.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.sistema.cliente.document.ClienteDocument;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteDocument, String> {}
