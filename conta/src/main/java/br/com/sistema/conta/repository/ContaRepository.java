package br.com.sistema.conta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.sistema.conta.document.ContaDocument;

@Repository
public interface ContaRepository extends MongoRepository<ContaDocument, String> {}
