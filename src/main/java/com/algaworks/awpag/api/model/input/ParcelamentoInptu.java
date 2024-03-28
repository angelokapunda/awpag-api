package com.algaworks.awpag.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ParcelamentoInptu {

    @NotBlank
    @Size(max = 20)
    private String descricao;

    @NotNull
    @Valid
    private ClientIdInput cliente;

    @NotNull
    @Positive
    private BigDecimal valorTotal;

    @NotNull
    @Positive
    @Max(12)
    private Integer QuantidadeParcelas;

}
