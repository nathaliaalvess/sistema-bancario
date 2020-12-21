package br.com.sistema.consulta.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import br.com.sistema.consulta.document.CartaoCreditoDocument;
import br.com.sistema.consulta.document.ChequeEspecialDocument;
import br.com.sistema.consulta.document.Cliente;
import br.com.sistema.consulta.document.ContaDocument;
import br.com.sistema.consulta.output.ConsultaOutput;
import br.com.sistema.consulta.repository.CartaoCreditoRepository;
import br.com.sistema.consulta.repository.ChequeEspecialRepository;
import br.com.sistema.consulta.repository.ContaRepository;

@RunWith(SpringJUnit4ClassRunner.class)
public class ConsultaServiceTeste {
  @InjectMocks private ConsultaService service;

  @Mock private ContaRepository contaRepository;

  @Mock private CartaoCreditoRepository cartaoCreditoRepository;

  @Mock private ChequeEspecialRepository chequeEspecialRepository;

  @Test
  public void deveListarContasComProdutos() {
    List<ContaDocument> contas = new ArrayList<ContaDocument>();
    contas.add(ContaDocument.builder().numero("000001").cliente(Cliente.builder().build()).build());
    contas.add(ContaDocument.builder().numero("000002").cliente(Cliente.builder().build()).build());

    when(contaRepository.findAll()).thenReturn(contas);
    when(cartaoCreditoRepository.findByContaNumero(Mockito.anyString()))
        .thenReturn(CartaoCreditoDocument.builder().build());
    when(chequeEspecialRepository.findByContaNumero(Mockito.anyString()))
        .thenReturn(ChequeEspecialDocument.builder().build());

    List<ConsultaOutput> resultado = service.listarContasComProdutos();

    assertEquals(2, resultado.size());
    verify(contaRepository).findAll();
    verify(cartaoCreditoRepository, Mockito.times(2)).findByContaNumero(Mockito.anyString());
    verify(chequeEspecialRepository, Mockito.times(2)).findByContaNumero(Mockito.anyString());
  }
}
