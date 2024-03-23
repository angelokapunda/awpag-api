package com.algaworks.awpag.domain.service;

import com.algaworks.awpag.domain.exception.NegocioException;
import com.algaworks.awpag.domain.model.Cliente;
import com.algaworks.awpag.domain.model.Parcelamento;
import com.algaworks.awpag.domain.repository.ParcelamentoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.OffsetDateTime;

@Service
@AllArgsConstructor
public class ParcelamentoService {

    private final ParcelamentoRepository parcelamentoRepository;
    private final CadastroClienteService cadastroClienteService;


    @Transactional
    public Parcelamento salvar(Parcelamento novoParcelamento) {
        if (novoParcelamento.getId() != null) {
            throw new NegocioException("Não pode ser adicionado um novo parcelamento com um código já existente.");
        }
        Cliente cliente = cadastroClienteService.buscar(novoParcelamento.getCliente().getId());

        novoParcelamento.setCliente(cliente);
//        novoParcelamento.setDataCriacao(OffsetDateTime.now());
        return parcelamentoRepository.save(novoParcelamento);
    }
}
