package br.com.sistema.cartao.credito;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class CataoCreditoApplication {

  public static void main(String[] args) {
    SpringApplication.run(CataoCreditoApplication.class, args);
  }
}
