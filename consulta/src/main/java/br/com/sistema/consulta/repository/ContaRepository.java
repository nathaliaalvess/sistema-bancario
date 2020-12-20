package br.com.sistema.consulta.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.sistema.consulta.document.ContaDocument;

@Repository
public interface ContaRepository extends MongoRepository<ContaDocument, String> {}
