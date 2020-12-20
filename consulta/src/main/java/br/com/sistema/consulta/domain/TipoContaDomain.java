package br.com.sistema.consulta.domain;

import lombok.Getter;

public enum TipoContaDomain {
  C("Conta Corrente"),
  E("Conta Empresarial");

  @Getter private String descricao;

  private TipoContaDomain(String descricao) {
    this.descricao = descricao;
  }
}
