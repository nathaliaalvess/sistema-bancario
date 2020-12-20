package br.com.sistema.conta.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import br.com.sistema.conta.document.ContaDocument;
import br.com.sistema.conta.repository.SequenceRepositoryImp;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class NumeroContaService {
  private static final int QTD_NUMEROS_CONTA = 6;
  private final SequenceRepositoryImp sequenceRepository;

  public String gerarNumeroConta() {
    String sequencial =
        Long.toString(sequenceRepository.buscarValorSequence(ContaDocument.SEQUENCE_NAME));

    return StringUtils.leftPad(sequencial, QTD_NUMEROS_CONTA, "0");
  }
}
