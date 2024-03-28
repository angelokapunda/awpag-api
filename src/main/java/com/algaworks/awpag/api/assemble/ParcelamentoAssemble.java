package com.algaworks.awpag.api.assemble;

import com.algaworks.awpag.api.model.ParcelamentoModel;
import com.algaworks.awpag.api.model.input.ParcelamentoInptu;
import com.algaworks.awpag.domain.model.Parcelamento;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class ParcelamentoAssemble {

    private final ModelMapper modelMapper;

    public ParcelamentoModel toModel(Parcelamento parcelamento) {
        return modelMapper.map(parcelamento , ParcelamentoModel.class);
    }

    public List<ParcelamentoModel> toList(List<Parcelamento> parcelamentos) {
        return parcelamentos.stream().map(parcelamento -> toModel(parcelamento))
                .toList();
    }

    public Parcelamento convertToEntity(ParcelamentoInptu parcelamentoInptu) {
        return modelMapper.map(parcelamentoInptu, Parcelamento.class);
    }
}
