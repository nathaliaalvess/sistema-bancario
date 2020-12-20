package br.com.sistema.cliente.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.fluttercode.datafactory.impl.DataFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.sistema.cliente.document.ClienteDocument;
import br.com.sistema.cliente.exception.DuplicateException;
import br.com.sistema.cliente.input.ClienteInput;
import br.com.sistema.cliente.producer.ClienteSalvoProducer;
import br.com.sistema.cliente.repository.ClienteRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ClienteServiceTest {
  @InjectMocks private ClienteService service;

  @Mock private ClienteRepository repository;

  @Mock private ClienteSalvoProducer clienteSalvoProducer;

  DataFactory df = new DataFactory();

  @Test
  public void deveRetornarErroAoTentarCadastrarClienteJaExistente() {
    String documento = "04573383000";

    when(repository.findById(documento)).thenReturn(Optional.of(ClienteDocument.builder().build()));

    try {
      service.cadastrar(buildClienteInput(documento));
    } catch (DuplicateException e) {
      assertTrue(e.getMessage().contains("O cliente com documento de número"));
    }
  }

  @Test
  public void deveCadastrarCliente() {
    String documento = "04573383000";

    when(repository.findById(documento)).thenReturn(Optional.empty());
    when(repository.save(Mockito.any())).thenReturn(ClienteDocument.builder().build());
    doNothing().when(clienteSalvoProducer).send(Mockito.anyString());

    ClienteDocument resultado = service.cadastrar(buildClienteInput(documento));

    assertNotNull(resultado);
    verify(repository).findById(documento);
    verify(repository).save(Mockito.any());
    verify(clienteSalvoProducer).send(Mockito.anyString());
  }

  @Test
  public void deveListarTodosOsClientesCadastrados() {
    List<ClienteDocument> clientes = new ArrayList<ClienteDocument>();
    clientes.add(ClienteDocument.builder().build());

    when(repository.findAll()).thenReturn(clientes);

    List<ClienteDocument> resultado = service.listarTodos();

    assertEquals(1, resultado.size());
    verify(repository).findAll();
  }

  private ClienteInput buildClienteInput(String documento) {
    return ClienteInput.builder().documento(documento).nome(df.getName()).build();
  }
}
