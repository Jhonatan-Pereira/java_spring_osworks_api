package com.jhonatanfrade.osworks.domain.repositories;

import com.jhonatanfrade.osworks.domain.model.OrdemServico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdemServicoRepository extends JpaRepository<OrdemServico, Long> {
  
}
