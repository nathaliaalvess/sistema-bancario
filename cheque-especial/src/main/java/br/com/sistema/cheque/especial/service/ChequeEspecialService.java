package br.com.sistema.cheque.especial.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import br.com.sistema.cheque.especial.document.ChequeEspecialDocument;
import br.com.sistema.cheque.especial.document.Conta;
import br.com.sistema.cheque.especial.repository.ChequeEspecialRepository;
import br.com.sistema.cheque.especial.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChequeEspecialService {

  private final ChequeEspecialRepository repository;

  @KafkaListener(topics = "${topic.name.consumer}", groupId = "${group.id}")
  public void salvar(ConsumerRecord<String, String> contaMensagem) {
    log.info("Iniciando criação de limite de cheque especial");

    Conta conta = (Conta) JsonUtils.toObject(contaMensagem.value(), Conta.class);

    log.info(
        "Concessão de limite de cheque especial para conta de número "
            .concat(conta.getNumero())
            .concat(" em andamento."));

    ChequeEspecialDocument chequeEspecial =
        repository.save(ChequeEspecialDocument.builder().conta(conta).build());

    log.info(
        "Limite de "
            .concat(chequeEspecial.getLimite().toString())
            .concat(" concedido para a conta de número ")
            .concat(chequeEspecial.getConta().getNumero()));
  }
}
