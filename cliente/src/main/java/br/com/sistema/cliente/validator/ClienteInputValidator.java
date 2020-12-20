package br.com.sistema.cliente.validator;

import br.com.sistema.cliente.input.ClienteInput;

public class ClienteInputValidator {

  public static void validar(ClienteInput cliente) {
    DocumentoValidator.validar(cliente.getDocumento());
  }
}
