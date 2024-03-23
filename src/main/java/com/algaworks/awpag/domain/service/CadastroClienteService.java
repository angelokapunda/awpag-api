package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@AllArgsConstructor
public class CadastroClienteService {

    private final ClienteRepository clienteRepository;


    public Cliente buscar (Long id) {
        return clienteRepository.findById(id)
                .orElseThrow( () -> new NegocioException("Cliente não existe."));
    }

    @Transactional
    public Cliente salvar( Cliente cliente) {

        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .filter(c -> !c.equals(cliente))
                .isPresent();

        if (emailEmUso) {
            throw new NegocioException("O email inserido já está cadastrado... Verifique e tente novamente.");
        }
        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long id) {
        clienteRepository.deleteById(id);
    }
}
