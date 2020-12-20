package br.com.sistema.consulta.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.sistema.consulta.output.ConsultaOutput;
import br.com.sistema.consulta.service.ConsultaService;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/consulta")
@AllArgsConstructor
public class ConsultaController {
  private final ConsultaService service;

  @GetMapping
  @ApiOperation(value = "Listar todas as contas com seus produtos e limites")
  public ResponseEntity<List<ConsultaOutput>> listarContasComProdutos() {
    return ResponseEntity.status(HttpStatus.OK).body(service.listarContasComProdutos());
  }
}
