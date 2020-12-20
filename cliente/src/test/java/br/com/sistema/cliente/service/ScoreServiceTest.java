package br.com.sistema.cliente.service;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class ScoreServiceTest {
  @InjectMocks private ScoreService service;

  private static final int SCORE_MINIMO = 0;
  private static final int SCORE_MAXIMO = 9;

  @Test
  public void deveGerarUmValorEntreMaxEMin() {
    Integer resultado = service.gerarScore();

    assertTrue(resultado >= SCORE_MINIMO);
    assertTrue(resultado <= SCORE_MAXIMO);
  }
}
