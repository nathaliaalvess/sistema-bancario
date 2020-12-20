package br.com.sistema.cheque.especial.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import br.com.sistema.cheque.especial.document.Conta;
import br.com.sistema.cheque.especial.document.FaixaChequeEspecialDocument;
import br.com.sistema.cheque.especial.exception.BusinessException;
import br.com.sistema.cheque.especial.repository.FaixaChequeEspecialRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LimiteChequeEspecialService {
  private final FaixaChequeEspecialRepository faixaRepository;

  public BigDecimal buscarLimite(Conta conta) {
    if (conta == null || conta.getCliente() == null || conta.getCliente().getScore() == null) {
      throw new BusinessException(
          "Não é possivel definir um limite de cheque especial, pois faltam informações.");
    }

    Integer score = conta.getCliente().getScore();

    FaixaChequeEspecialDocument faixa =
        faixaRepository
            .findByScore(score)
            .orElseThrow(
                () ->
                    new BusinessException(
                        "Nenhum limite definido para o score ".concat(score.toString())));

    return faixa.getLimite();
  }
}
