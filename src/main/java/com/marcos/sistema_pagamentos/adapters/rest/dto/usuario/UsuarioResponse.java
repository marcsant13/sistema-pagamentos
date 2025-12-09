package com.marcos.sistema_pagamentos.adapters.rest.dto.usuario;

import com.marcos.sistema_pagamentos.domain.enumcls.StatusUsuario;

public record UsuarioResponse(
        Long id,
        String nome,
        String email,
        StatusUsuario statusUsuario
) {
}
