package br.com.sistema.cliente.listener;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Service;
import br.com.sistema.cliente.document.ClienteDocument;
import br.com.sistema.cliente.service.ScoreService;
import br.com.sistema.cliente.service.TipoPessoaService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteListener extends AbstractMongoEventListener<ClienteDocument> {
  private final TipoPessoaService tipoPessoaService;
  private final ScoreService scoreService;

  @Override
  public void onBeforeConvert(BeforeConvertEvent<ClienteDocument> event) {
    ClienteDocument cliente = event.getSource();
    cliente.setTipoPessoa(tipoPessoaService.buscarTipoPessoa(cliente));
    cliente.setScore(scoreService.gerarScore());
  }
}
