package br.com.sistema.conta.service;

import org.springframework.stereotype.Service;
import br.com.sistema.conta.document.Cliente;
import br.com.sistema.conta.domain.TipoContaDomain;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoContaService {

  public TipoContaDomain buscarTipoConta(Cliente cliente) {
    return cliente.isPF() ? TipoContaDomain.C : TipoContaDomain.E;
  }
}
