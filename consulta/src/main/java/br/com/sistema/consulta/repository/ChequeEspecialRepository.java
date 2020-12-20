package br.com.sistema.consulta.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.sistema.consulta.document.ChequeEspecialDocument;

@Repository
public interface ChequeEspecialRepository
    extends MongoRepository<ChequeEspecialDocument, ObjectId> {

  ChequeEspecialDocument findByContaNumero(String numero);
}
