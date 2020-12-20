package br.com.sistema.cheque.especial.listener;

import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.stereotype.Service;
import br.com.sistema.cheque.especial.document.ChequeEspecialDocument;
import br.com.sistema.cheque.especial.service.LimiteChequeEspecialService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChequeEspecialListener extends AbstractMongoEventListener<ChequeEspecialDocument> {
  private final LimiteChequeEspecialService limiteChequeEspecialService;

  @Override
  public void onBeforeConvert(BeforeConvertEvent<ChequeEspecialDocument> event) {
    ChequeEspecialDocument chequeEspecial = event.getSource();
    chequeEspecial.setLimite(limiteChequeEspecialService.buscarLimite(chequeEspecial.getConta()));
  }
}
