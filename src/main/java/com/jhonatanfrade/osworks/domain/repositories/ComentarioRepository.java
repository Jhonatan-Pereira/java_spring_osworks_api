package com.jhonatanfrade.osworks.domain.repositories;

import com.jhonatanfrade.osworks.domain.model.Comentario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
  
}
