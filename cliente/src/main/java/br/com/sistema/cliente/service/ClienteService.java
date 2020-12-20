package br.com.sistema.cliente.service;

import java.util.List;
import org.springframework.stereotype.Service;
import br.com.sistema.cliente.document.ClienteDocument;
import br.com.sistema.cliente.exception.DuplicateException;
import br.com.sistema.cliente.input.ClienteInput;
import br.com.sistema.cliente.producer.ClienteSalvoProducer;
import br.com.sistema.cliente.repository.ClienteRepository;
import br.com.sistema.cliente.utils.JsonUtils;
import br.com.sistema.cliente.validator.ClienteInputValidator;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClienteService {

  private final ClienteRepository repository;

  private final ClienteSalvoProducer clienteSalvoProducer;

  public ClienteDocument cadastrar(ClienteInput cliente) {
    ClienteInputValidator.validar(cliente);

    validarClienteCadastrado(cliente);

    ClienteDocument clienteSalvo = repository.save(buildCliente(cliente));
    clienteSalvoProducer.send(JsonUtils.toJson(clienteSalvo));

    return clienteSalvo;
  }

  private void validarClienteCadastrado(ClienteInput cliente) {
    if (repository.findById(cliente.getDocumento()).isPresent()) {
      throw new DuplicateException(
          "O cliente com documento de número "
              .concat(cliente.getDocumento())
              .concat(" já foi cadastrado."));
    }
  }

  private ClienteDocument buildCliente(ClienteInput cliente) {
    return ClienteDocument.builder()
        .documento(cliente.getDocumento())
        .nome(cliente.getNome())
        .build();
  }

  public List<ClienteDocument> listarTodos() {
    return repository.findAll();
  }
}
