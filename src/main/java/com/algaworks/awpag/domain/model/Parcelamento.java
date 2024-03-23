package com.algaworks.awpag.domain.model;

import com.algaworks.awpag.domain.validation.ValidationGroups;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jakarta.validation.groups.ConvertGroup;
import jakarta.validation.groups.Default;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
@Entity
@Table(name = "parcelamentos")
@EqualsAndHashCode(of = "id")
public class Parcelamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 20)
    private String descricao;

    @Positive
    @NotNull
    private BigDecimal valorTotal;

    @Positive
    @Max(12)
    @NotNull
    private Integer quantidadeParcelas;

    @CreationTimestamp
    private OffsetDateTime dataCriacao;


    @NotNull
    @ManyToOne
    @Valid
    @ConvertGroup(from = Default.class,  to =   ValidationGroups.cozinhaId.class)
    private Cliente cliente;



}
