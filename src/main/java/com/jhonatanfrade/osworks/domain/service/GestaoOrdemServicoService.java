package com.jhonatanfrade.osworks.domain.service;

import java.time.OffsetDateTime;

import com.jhonatanfrade.osworks.domain.exception.NegocioException;
import com.jhonatanfrade.osworks.domain.model.Cliente;
import com.jhonatanfrade.osworks.domain.model.OrdemServico;
import com.jhonatanfrade.osworks.domain.model.StatusOrdemServico;
import com.jhonatanfrade.osworks.domain.repositories.ClienteRepository;
import com.jhonatanfrade.osworks.domain.repositories.OrdemServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestaoOrdemServicoService {

  @Autowired
  private OrdemServicoRepository ordemServicoRepository;

  @Autowired
  private ClienteRepository clienteRepository;
  
  public OrdemServico criar(OrdemServico ordemServico) {

    Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
      .orElseThrow(() -> new NegocioException("Clliente não encontrado"));

    ordemServico.setCliente(cliente);
    ordemServico.setStatus(StatusOrdemServico.ABERTA);
    ordemServico.setDataAbertura(OffsetDateTime.now());

    return ordemServicoRepository.save(ordemServico);
  }

}
