package com.algaworks.awpag.api.model;

import com.algaworks.awpag.domain.model.Cliente;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class ParcelamentoModel {

    private Long id;
    private String cliente;
    private String descricao;
    private BigDecimal valorTotal;
    private Integer parcelas;
    private OffsetDateTime dataCriacao;
}
