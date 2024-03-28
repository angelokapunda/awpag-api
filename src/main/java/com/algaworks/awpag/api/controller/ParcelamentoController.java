package com.algaworks.awpag.api.controller;

import com.algaworks.awpag.api.assemble.ParcelamentoAssemble;
import com.algaworks.awpag.api.model.ParcelamentoModel;
import com.algaworks.awpag.api.model.input.ParcelamentoInptu;
import com.algaworks.awpag.domain.model.Parcelamento;
import com.algaworks.awpag.domain.repository.ParcelamentoRepository;
import com.algaworks.awpag.domain.service.ParcelamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/parcelamentos")
public class ParcelamentoController {

    private ParcelamentoRepository parcelamentoRepository;
    private ParcelamentoService parcelamentoService;
    private ParcelamentoAssemble parcelamentoAssemble;

    @GetMapping
    public List<ParcelamentoModel> lista () {
        return parcelamentoAssemble.toList(parcelamentoRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParcelamentoModel> buscar(@PathVariable Long id) {
        return parcelamentoRepository.findById(id)
                .map( parcelamento -> parcelamentoAssemble.toModel(parcelamento))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.badRequest().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ParcelamentoModel cadastrar(@Valid @RequestBody ParcelamentoInptu parcelamentoInptu) {
        Parcelamento novoParcelamento = parcelamentoAssemble.convertToEntity(parcelamentoInptu);
        Parcelamento parcelamentoCadastrado =  parcelamentoService.salvar(novoParcelamento);
        return parcelamentoAssemble.toModel(parcelamentoCadastrado);
    }

}

//Vagas@novigo.com.br
