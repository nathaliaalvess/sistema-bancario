package br.com.sistema.conta.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.sistema.conta.document.Cliente;
import br.com.sistema.conta.domain.TipoContaDomain;
import br.com.sistema.conta.domain.TipoPessoaDomain;

@RunWith(SpringJUnit4ClassRunner.class)
public class TipoContaServiceTest {
  @InjectMocks private TipoContaService service;

  @Test
  public void deveRetornarTipoContaCorrenteParaClientePF() {
    Cliente cliente = Cliente.builder().tipoPessoa(TipoPessoaDomain.PF).build();

    TipoContaDomain resultado = service.buscarTipoConta(cliente);

    assertEquals(TipoContaDomain.C, resultado);
  }

  @Test
  public void deveRetornarTipoContaEmpresarialParaClientePJ() {
    Cliente cliente = Cliente.builder().tipoPessoa(TipoPessoaDomain.PJ).build();

    TipoContaDomain resultado = service.buscarTipoConta(cliente);

    assertEquals(TipoContaDomain.E, resultado);
  }
}
