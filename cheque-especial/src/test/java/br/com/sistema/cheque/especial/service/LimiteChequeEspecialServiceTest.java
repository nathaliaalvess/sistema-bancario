package br.com.sistema.cheque.especial.service;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import java.util.Optional;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.sistema.cheque.especial.document.Cliente;
import br.com.sistema.cheque.especial.document.Conta;
import br.com.sistema.cheque.especial.document.FaixaChequeEspecialDocument;
import br.com.sistema.cheque.especial.exception.BusinessException;
import br.com.sistema.cheque.especial.repository.FaixaChequeEspecialRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class LimiteChequeEspecialServiceTest {
  @InjectMocks private LimiteChequeEspecialService service;

  @Mock private FaixaChequeEspecialRepository faixaRepository;

  @Test
  public void deveRetornarErroQuandoContaNaoForInfomada() {
    try {
      service.buscarLimite(null);
    } catch (BusinessException e) {
      assertEquals(
          "Não é possivel definir um limite de cheque especial, pois faltam informações.",
          e.getMessage());
    }
  }

  @Test
  public void deveRetornarErroQuandoNaoEncontrarFaixaParaScore() {
    int score = 1;

    when(faixaRepository.findByScore(score)).thenReturn(Optional.empty());

    try {
      service.buscarLimite(Conta.builder().cliente(Cliente.builder().score(score).build()).build());
    } catch (BusinessException e) {
      assertTrue(e.getMessage().contains("Nenhum limite definido para o score"));
    }
  }

  @Test
  public void deveRetornarLimite() {
    int score = 1;
    BigDecimal limite = BigDecimal.ONE;

    when(faixaRepository.findByScore(score))
        .thenReturn(Optional.of(FaixaChequeEspecialDocument.builder().limite(limite).build()));

    BigDecimal resultado =
        service.buscarLimite(
            Conta.builder().cliente(Cliente.builder().score(score).build()).build());

    assertEquals(limite, resultado);
  }
}
