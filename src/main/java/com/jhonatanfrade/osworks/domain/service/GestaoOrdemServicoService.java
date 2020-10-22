package com.jhonatanfrade.osworks.domain.service;

import java.time.OffsetDateTime;

import com.jhonatanfrade.osworks.domain.exception.EntidadeNaoEncontradaException;
import com.jhonatanfrade.osworks.domain.exception.NegocioException;
import com.jhonatanfrade.osworks.domain.model.Cliente;
import com.jhonatanfrade.osworks.domain.model.Comentario;
import com.jhonatanfrade.osworks.domain.model.OrdemServico;
import com.jhonatanfrade.osworks.domain.model.StatusOrdemServico;
import com.jhonatanfrade.osworks.domain.repositories.ClienteRepository;
import com.jhonatanfrade.osworks.domain.repositories.ComentarioRepository;
import com.jhonatanfrade.osworks.domain.repositories.OrdemServicoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GestaoOrdemServicoService {

  @Autowired
  private OrdemServicoRepository ordemServicoRepository;

  @Autowired
  private ClienteRepository clienteRepository;

  @Autowired
  private ComentarioRepository comentarioRepository;
  
  public OrdemServico criar(OrdemServico ordemServico) {

    Cliente cliente = clienteRepository.findById(ordemServico.getCliente().getId())
      .orElseThrow(() -> new NegocioException("Cliente não encontrado."));

    ordemServico.setCliente(cliente);
    ordemServico.setStatus(StatusOrdemServico.ABERTA);
    ordemServico.setDataAbertura(OffsetDateTime.now());

    return ordemServicoRepository.save(ordemServico);
  }

  public Comentario adicionar(Long ordemServicoId, String descricao) {
    OrdemServico ordemServico = ordemServicoRepository.findById(ordemServicoId)
      .orElseThrow(() -> new EntidadeNaoEncontradaException("Ordem de serviço não identificada."));

    Comentario comentario = new Comentario();
    comentario.setDataEnvio(OffsetDateTime.now());
    comentario.setDescricao(descricao);

    comentario.setOrdemServico(ordemServico);

    return comentarioRepository.save(comentario);
  }

}
