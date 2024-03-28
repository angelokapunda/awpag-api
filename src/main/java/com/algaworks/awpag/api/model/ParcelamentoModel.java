package com.algaworks.awpag.api.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class ParcelamentoModel {

    private Long id;
    private ClienteResumoModel cliente;
    private String descricao;
    private BigDecimal valorTotal;
    private Integer parcelas;
    private OffsetDateTime dataCriacao;
}
