package br.com.sistema.cliente.service;

import org.springframework.stereotype.Service;
import br.com.sistema.cliente.document.ClienteDocument;
import br.com.sistema.cliente.domain.TipoPessoaDomain;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoPessoaService {
  private static final int QTD_NUMEROS_CPF = 11;

  public TipoPessoaDomain buscarTipoPessoa(ClienteDocument cliente) {
    return cliente.getDocumento().length() == QTD_NUMEROS_CPF
        ? TipoPessoaDomain.PF
        : TipoPessoaDomain.PJ;
  }
}
