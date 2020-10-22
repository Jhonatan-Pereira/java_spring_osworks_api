package com.jhonatanfrade.osworks.api.controller;

import javax.validation.Valid;

import com.jhonatanfrade.osworks.domain.model.OrdemServico;
import com.jhonatanfrade.osworks.domain.service.GestaoOrdemServicoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordem-servico")
public class OrdemServicoController {

  @Autowired
  private GestaoOrdemServicoService gestaoOrdemServico;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public OrdemServico criar(@Valid @RequestBody OrdemServico ordemServico) {
    return gestaoOrdemServico.criar(ordemServico);
  }
}
