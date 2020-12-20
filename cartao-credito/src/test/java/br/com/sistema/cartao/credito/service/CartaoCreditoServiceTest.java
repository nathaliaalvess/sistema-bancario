package br.com.sistema.cartao.credito.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.math.BigDecimal;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.sistema.cartao.credito.document.CartaoCreditoDocument;
import br.com.sistema.cartao.credito.document.Conta;
import br.com.sistema.cartao.credito.repository.CartaoCreditoRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class CartaoCreditoServiceTest {
  @InjectMocks private CartaoCreditoService service;

  @Mock private CartaoCreditoRepository repository;

  @Test
  public void deveGerarCartaoCredito() {
    ConsumerRecord<String, String> contaMensagem =
        new ConsumerRecord<String, String>(
            "", 1, 1l, "", " {\"numero\": \"000001\", \"agencia\": \"123\"}");

    when(repository.save(Mockito.any()))
        .thenReturn(
            CartaoCreditoDocument.builder()
                .conta(Conta.builder().numero("000001").build())
                .limite(BigDecimal.ONE)
                .build());

    service.salvar(contaMensagem);

    verify(repository).save(Mockito.any());
  }
}
