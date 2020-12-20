package br.com.sistema.cliente.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.sistema.cliente.document.ClienteDocument;
import br.com.sistema.cliente.input.ClienteInput;
import br.com.sistema.cliente.service.ClienteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/cliente")
@Api(tags = "Cliente")
public class ClienteController {

  private final ClienteService service;

  @GetMapping
  @ApiOperation(value = "Listar todos os clientes cadastradas")
  public ResponseEntity<List<ClienteDocument>> listarTodos() {
    return ResponseEntity.status(HttpStatus.OK).body(service.listarTodos());
  }

  @PostMapping
  @ApiOperation(value = "Cadastrar um novo cliente")
  public ResponseEntity<ClienteDocument> post(@RequestBody ClienteInput cliente) {
    return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(cliente));
  }
}
