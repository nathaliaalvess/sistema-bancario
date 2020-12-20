package br.com.sistema.conta.listener;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Service;
import br.com.sistema.conta.document.ContaDocument;
import br.com.sistema.conta.service.NumeroContaService;
import br.com.sistema.conta.service.TipoContaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContaListener extends AbstractMongoEventListener<ContaDocument> {
  @Value("${app.agencia}")
  private String agencia;

  private final NumeroContaService numeroContaService;
  private final TipoContaService tipoContaService;

  @Override
  public void onBeforeConvert(BeforeConvertEvent<ContaDocument> event) {
    ContaDocument conta = event.getSource();
    conta.setNumero(numeroContaService.gerarNumeroConta());
    conta.setAgencia(agencia);
    conta.setTipo(tipoContaService.buscarTipoConta(conta.getCliente()));
  }
}
