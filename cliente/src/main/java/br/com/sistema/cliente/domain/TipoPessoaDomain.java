package br.com.sistema.cliente.domain;

import lombok.Getter;

public enum TipoPessoaDomain {
  PF("Pessoa Física"),
  PJ("Pessoa Jurídica");

  @Getter private String descricao;

  private TipoPessoaDomain(String descricao) {
    this.descricao = descricao;
  }
}
