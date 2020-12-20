package br.com.sistema.consulta.service;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import br.com.sistema.consulta.document.CartaoCreditoDocument;
import br.com.sistema.consulta.document.ChequeEspecialDocument;
import br.com.sistema.consulta.document.ContaDocument;
import br.com.sistema.consulta.output.CartaoCreditoOutput;
import br.com.sistema.consulta.output.ChequeEspecialOutput;
import br.com.sistema.consulta.output.ConsultaOutput;
import br.com.sistema.consulta.repository.CartaoCreditoRepository;
import br.com.sistema.consulta.repository.ChequeEspecialRepository;
import br.com.sistema.consulta.repository.ContaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ConsultaService {
  private final ContaRepository contaRepository;

  private final CartaoCreditoRepository cartaoCreditoRepository;

  private final ChequeEspecialRepository chequeEspecialRepository;

  public List<ConsultaOutput> listarContasComProdutos() {
    return contaRepository.findAll().stream().map(this::buildConsulta).collect(Collectors.toList());
  }

  private ConsultaOutput buildConsulta(ContaDocument conta) {
    return ConsultaOutput.builder()
        .agenciaConta(conta.getAgencia())
        .documentoCliente(conta.getCliente().getDocumento())
        .numeroConta(conta.getNumero())
        .tipoConta(conta.getTipo())
        .cartaoCredito(buildcartaoCredito(conta.getNumero()))
        .chequeEspecial(buildChequeEspecial(conta.getNumero()))
        .build();
  }

  private CartaoCreditoOutput buildcartaoCredito(String numero) {
    CartaoCreditoDocument cartao = cartaoCreditoRepository.findByContaNumero(numero);
    return CartaoCreditoOutput.builder()
        .numero(cartao.getNumero())
        .limite(cartao.getLimite())
        .build();
  }

  private ChequeEspecialOutput buildChequeEspecial(String numero) {
    ChequeEspecialDocument cheque = chequeEspecialRepository.findByContaNumero(numero);
    return ChequeEspecialOutput.builder().limite(cheque.getLimite()).build();
  }
}
