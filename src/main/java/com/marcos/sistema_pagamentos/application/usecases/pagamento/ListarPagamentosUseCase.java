package com.marcos.sistema_pagamentos.application.usecases.pagamento;

import com.marcos.sistema_pagamentos.application.usecases.usuario.BuscarUsuarioIdUseCase;
import com.marcos.sistema_pagamentos.domain.model.Usuario;

public class ListarPagamentosUseCase {

    private final BuscarUsuarioIdUseCase buscarUsuarioIdUseCase;

    public ListarPagamentosUseCase(BuscarUsuarioIdUseCase buscarUsuarioIdUseCase) {
        this.buscarUsuarioIdUseCase = buscarUsuarioIdUseCase;
    }

    public Usuario listarPagamentos(Long idUsuario) {
        return buscarUsuarioIdUseCase.buscarUsuarioId(idUsuario);
    }
}
