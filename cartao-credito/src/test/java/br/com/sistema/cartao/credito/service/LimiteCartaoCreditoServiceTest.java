package br.com.sistema.cartao.credito.service;

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
import br.com.sistema.cartao.credito.document.Cliente;
import br.com.sistema.cartao.credito.document.Conta;
import br.com.sistema.cartao.credito.document.FaixaCartaoCreditoDocument;
import br.com.sistema.cartao.credito.exception.BusinessException;
import br.com.sistema.cartao.credito.repository.FaixaCartaoCreditoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class LimiteCartaoCreditoServiceTest {
  @InjectMocks private LimiteCartaoCreditoService service;

  @Mock private FaixaCartaoCreditoRepository faixaRepository;

  @Test
  public void deveRetornarErroQuandoContaNaoForInfomada() {
    try {
      service.buscarLimite(null);
    } catch (BusinessException e) {
      assertEquals(
          "Não é possivel definir um limite de cartao credito, pois faltam informações.",
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
        .thenReturn(Optional.of(FaixaCartaoCreditoDocument.builder().limite(limite).build()));

    BigDecimal resultado =
        service.buscarLimite(
            Conta.builder().cliente(Cliente.builder().score(score).build()).build());

    assertEquals(limite, resultado);
  }
}
