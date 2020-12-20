package br.com.sistema.conta.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import br.com.sistema.conta.document.Cliente;
import br.com.sistema.conta.document.ContaDocument;
import br.com.sistema.conta.producer.ContaCriadaProducer;
import br.com.sistema.conta.repository.ContaRepository;
import br.com.sistema.conta.utils.JsonUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ContaService {

  private final ContaRepository repository;
  private final ContaCriadaProducer producer;

  @KafkaListener(topics = "${topic.name.consumer}", groupId = "${group.id}")
  public ContaDocument criarConta(ConsumerRecord<String, String> clienteMensagem) {
    log.info("Iniciando criação da conta");

    Cliente cliente = (Cliente) JsonUtils.toObject(clienteMensagem.value(), Cliente.class);

    log.info(
        "Criação da conta do cliente de documento número "
            .concat(cliente.getDocumento())
            .concat(" em andamento."));

    ContaDocument conta = repository.save(ContaDocument.builder().cliente(cliente).build());

    producer.send(JsonUtils.toJson(conta));

    log.info(
        "Conta "
            .concat(conta.getNumero())
            .concat(" criada para o cliente de documento número ")
            .concat(conta.getCliente().getDocumento()));

    return conta;
  }
}
