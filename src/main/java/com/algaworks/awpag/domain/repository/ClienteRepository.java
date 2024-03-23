package com.algaworks.awpag.domain.repository;

import com.algaworks.awpag.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByNome(String nome);
    Optional<Cliente> findByEmail(String email);
}
