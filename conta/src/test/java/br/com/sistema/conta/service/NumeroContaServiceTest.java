package br.com.sistema.conta.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.sistema.conta.document.ContaDocument;
import br.com.sistema.conta.repository.SequenceRepositoryImp;

@RunWith(SpringJUnit4ClassRunner.class)
public class NumeroContaServiceTest {
  @InjectMocks private NumeroContaService service;

  @Mock private SequenceRepositoryImp sequenceRepository;

  private static final int QTD_NUMEROS_CONTA = 6;

  @Test
  public void deveGerarNumeroDaConta() {
    when(sequenceRepository.buscarValorSequence(ContaDocument.SEQUENCE_NAME)).thenReturn(1l);

    String resultado = service.gerarNumeroConta();

    assertEquals("000001", resultado);
    assertEquals(QTD_NUMEROS_CONTA, resultado.length());
  }
}
