package com.marcos.sistema_pagamentos.adapters.rest.dto.usuario;

import com.marcos.sistema_pagamentos.domain.enumcls.StatusUsuario;
import jakarta.validation.constraints.NotNull;

public record AlterarStatusUsuarioRequest(
        @NotNull(message = "preencha um valor de id valido")
        Long id,
        @NotNull(message = "preencha um status valido")
        StatusUsuario statusUsuario
) {
}
