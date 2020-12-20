package br.com.sistema.cartao.credito.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import br.com.sistema.cartao.credito.document.CartaoCreditoDocument;
import br.com.sistema.cartao.credito.document.Conta;
import br.com.sistema.cartao.credito.repository.CartaoCreditoRepository;
import br.com.sistema.cartao.credito.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CartaoCreditoService {

  private final CartaoCreditoRepository repository;

  @KafkaListener(topics = "${topic.name.consumer}", groupId = "${group.id}")
  public void salvar(ConsumerRecord<String, String> contaMensagem) {
    log.info("Iniciando criação do cartão de crédito");

    Conta conta = (Conta) JsonUtils.toObject(contaMensagem.value(), Conta.class);

    log.info(
        "Concessão de limite de cartão de crédito para conta de número "
            .concat(conta.getNumero())
            .concat(" em andamento."));

    CartaoCreditoDocument cartaoCredito =
        repository.save(CartaoCreditoDocument.builder().conta(conta).build());

    log.info(
        "Limite de "
            .concat(cartaoCredito.getLimite().toString())
            .concat(" concedido para a conta de número ")
            .concat(cartaoCredito.getConta().getNumero()));
  }
}
