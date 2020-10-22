package com.jhonatanfrade.osworks.api.controller;

import java.util.List;

import com.jhonatanfrade.osworks.domain.model.Cliente;
import com.jhonatanfrade.osworks.domain.repositories.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

  @Autowired
  private ClienteRepository clienteRepository;
  
  @GetMapping("/clientes")
  public List<Cliente> listar() {
    return clienteRepository.findAll();
  }
}
