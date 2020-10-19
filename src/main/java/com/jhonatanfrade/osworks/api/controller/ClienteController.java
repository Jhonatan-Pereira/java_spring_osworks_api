package com.jhonatanfrade.osworks.api.controller;

import java.util.Arrays;
import java.util.List;

import com.jhonatanfrade.osworks.domain.model.Cliente;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
  
  @GetMapping("/clientes")
  public List<Cliente> listar() {
    var cliente1 = new Cliente();
    cliente1.setId(1L);
    cliente1.setNome("João das neves");
    cliente1.setTelefone("15975345685");
    cliente1.setEmail("joao@uol.com");
    var cliente2 = new Cliente();
    cliente2.setId(2L);
    cliente2.setNome("Maria");
    cliente2.setTelefone("45685245815");
    cliente2.setEmail("maria@uol.com");

    return Arrays.asList(cliente1, cliente2);
  }
}
