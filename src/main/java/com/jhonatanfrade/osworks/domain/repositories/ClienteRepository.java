package com.jhonatanfrade.osworks.domain.repositories;

import java.util.List;

import com.jhonatanfrade.osworks.domain.model.Cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

  List<Cliente> findByNome(String nome);
  List<Cliente> findByNomeContaining(String nome);
  Cliente findByEmail(String email);
  
}
