package com.jhonatanfrade.osworks.api.controller;

import java.util.List;
import java.util.Optional;

import com.jhonatanfrade.osworks.domain.model.Cliente;
import com.jhonatanfrade.osworks.domain.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;
  
  @GetMapping("/clientes")
  public List<Cliente> listar() {
    return clienteRepository.findAll();
    // return clienteRepository.findByNome("joao da silva");
    // return clienteRepository.findByNomeContaining("ria");
  }

  @GetMapping("/clientes/{clienteId}")
  public ResponseEntity<Cliente> buscar(@PathVariable long clienteId) {
    Optional<Cliente> cliente = clienteRepository.findById(clienteId);

    if(cliente.isPresent()) {
      return ResponseEntity.ok(cliente.get());
    }

    return ResponseEntity.notFound().build();
  }
}
