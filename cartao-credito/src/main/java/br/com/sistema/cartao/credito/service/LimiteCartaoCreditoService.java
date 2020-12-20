package br.com.sistema.cartao.credito.service;

import java.math.BigDecimal;
import org.springframework.stereotype.Service;
import br.com.sistema.cartao.credito.document.Conta;
import br.com.sistema.cartao.credito.document.FaixaCartaoCreditoDocument;
import br.com.sistema.cartao.credito.exception.BusinessException;
import br.com.sistema.cartao.credito.repository.FaixaCartaoCreditoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LimiteCartaoCreditoService {
  private final FaixaCartaoCreditoRepository faixaRepository;

  public BigDecimal buscarLimite(Conta conta) {
    if (conta == null || conta.getCliente() == null || conta.getCliente().getScore() == null) {
      throw new BusinessException(
          "Não é possivel definir um limite de cartao credito, pois faltam informações.");
    }

    Integer score = conta.getCliente().getScore();

    FaixaCartaoCreditoDocument faixa =
        faixaRepository
            .findByScore(score)
            .orElseThrow(
                () ->
                    new BusinessException(
                        "Nenhum limite definido para o score ".concat(score.toString())));

    return faixa.getLimite();
  }
}
