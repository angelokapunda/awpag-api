package com.algaworks.awpag.api.model.input;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ClientIdInput {

    @NotNull
    private Long id;
}
