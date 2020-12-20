package br.com.sistema.cartao.credito.service;

import java.util.Random;
import org.springframework.stereotype.Service;
import br.com.sistema.cartao.credito.document.Conta;

@Service
public class NumeroCartaoCreditoService {

  private static final int QTD_NUMEROS_COMPOR_CARTAO = 10;

  public String gerarNumeroCartao(Conta conta) {
    return conta.getNumero().concat(generateRandomDigits(QTD_NUMEROS_COMPOR_CARTAO).toString());
  }

  private Integer generateRandomDigits(int n) {
    int m = (int) Math.pow(10, n - 1);
    return m + new Random().nextInt(9 * m);
  }
}
