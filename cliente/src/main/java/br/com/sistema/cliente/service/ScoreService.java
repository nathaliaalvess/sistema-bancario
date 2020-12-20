package br.com.sistema.cliente.service;

import java.util.concurrent.ThreadLocalRandom;
import org.springframework.stereotype.Service;

@Service
public class ScoreService {

  private static final int SCORE_MINIMO = 0;
  private static final int SCORE_MAXIMO = 9;

  public Integer gerarScore() {
    return ThreadLocalRandom.current().nextInt(SCORE_MINIMO, SCORE_MAXIMO + 1);
  }
}
