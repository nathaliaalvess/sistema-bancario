package br.com.sistema.cheque.especial.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import br.com.sistema.cheque.especial.document.ChequeEspecialDocument;

@Repository
public interface ChequeEspecialRepository
    extends MongoRepository<ChequeEspecialDocument, ObjectId> {}
