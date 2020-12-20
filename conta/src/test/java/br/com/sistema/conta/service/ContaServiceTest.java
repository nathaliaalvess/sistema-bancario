package br.com.sistema.conta.service;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.sistema.conta.document.Cliente;
import br.com.sistema.conta.document.ContaDocument;
import br.com.sistema.conta.producer.ContaCriadaProducer;
import br.com.sistema.conta.repository.ContaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ContaServiceTest {
  @InjectMocks ContaService service;

  @Mock private ContaRepository repository;

  @Mock private ContaCriadaProducer producer;

  @Test
  public void deveCriarUmaContaEPostarMensagem() {
    ConsumerRecord<String, String> clienteMensagem =
        new ConsumerRecord<String, String>(
            "",
            1,
            1l,
            "",
            " {\"documento\": \"59436805004\", \"tipoPessoa\": \"PF\", \"score\": 0}");

    when(repository.save(Mockito.any()))
        .thenReturn(
            ContaDocument.builder()
                .numero("")
                .cliente(Cliente.builder().documento("").build())
                .build());
    doNothing().when(producer).send(Mockito.anyString());

    service.criarConta(clienteMensagem);

    verify(repository).save(Mockito.any());
    verify(producer).send(Mockito.anyString());
  }
}
