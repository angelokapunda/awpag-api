package com.algaworks.awpag.api.controller;

import com.algaworks.awpag.api.model.ParcelamentoModel;
import com.algaworks.awpag.domain.model.Parcelamento;
import com.algaworks.awpag.domain.repository.ParcelamentoRepository;
import com.algaworks.awpag.domain.service.ParcelamentoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
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

    @GetMapping
    public List<Parcelamento> lista () {
        return parcelamentoRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParcelamentoModel> buscar(@PathVariable Long id) {
        return parcelamentoRepository.findById(id).map( parcelamento -> {

            ParcelamentoModel parcelamentoModel = new ParcelamentoModel();

            parcelamentoModel.setId(parcelamento.getId());
            parcelamentoModel.setCliente(parcelamento.getCliente().getNome());
            parcelamentoModel.setDescricao(parcelamento.getDescricao());
            parcelamentoModel.setValorTotal(parcelamento.getValorTotal());
            parcelamentoModel.setParcelas(parcelamento.getQuantidadeParcelas());
            parcelamentoModel.setDataCriacao(parcelamento.getDataCriacao());

            return ResponseEntity.ok(parcelamentoModel);
        }).orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Parcelamento cadastrar(@Valid @RequestBody Parcelamento parcelamento) {
        return parcelamentoService.salvar(parcelamento);
    }

}
