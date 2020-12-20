package br.com.sistema.cliente.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.sistema.cliente.document.ClienteDocument;
import br.com.sistema.cliente.domain.TipoPessoaDomain;

@RunWith(SpringJUnit4ClassRunner.class)
public class TipoPessoaServiceTest {
  @InjectMocks private TipoPessoaService service;

  @Test
  public void deveRetornarTipoPFQuandoDocumentoCPF() {
    TipoPessoaDomain resultado =
        service.buscarTipoPessoa(ClienteDocument.builder().documento("04573383000").build());

    assertEquals(TipoPessoaDomain.PF, resultado);
  }

  @Test
  public void deveRetornarTipoPJQuandoDocumentoCNPJ() {
    TipoPessoaDomain resultado =
        service.buscarTipoPessoa(ClienteDocument.builder().documento("71008754000136").build());

    assertEquals(TipoPessoaDomain.PJ, resultado);
  }
}
