package br.com.sistema.cartao.credito.listener;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Service;
import br.com.sistema.cartao.credito.document.CartaoCreditoDocument;
import br.com.sistema.cartao.credito.document.Conta;
import br.com.sistema.cartao.credito.service.LimiteCartaoCreditoService;
import br.com.sistema.cartao.credito.service.NumeroCartaoCreditoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CartaoCreditoListener extends AbstractMongoEventListener<CartaoCreditoDocument> {

  private final LimiteCartaoCreditoService limiteCartaoCreditoService;

  private final NumeroCartaoCreditoService numeroCartaoCreditoService;

  @Override
  public void onBeforeConvert(BeforeConvertEvent<CartaoCreditoDocument> event) {
    CartaoCreditoDocument cartaoCredito = event.getSource();
    Conta conta = cartaoCredito.getConta();
    cartaoCredito.setNumero(numeroCartaoCreditoService.gerarNumeroCartao(conta));
    cartaoCredito.setLimite(limiteCartaoCreditoService.buscarLimite(conta));
  }
}
