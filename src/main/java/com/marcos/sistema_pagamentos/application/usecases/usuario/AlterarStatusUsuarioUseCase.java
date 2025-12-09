package com.marcos.sistema_pagamentos.application.usecases.usuario;

import com.marcos.sistema_pagamentos.adapters.rest.dto.usuario.AlterarStatusUsuarioRequest;
import com.marcos.sistema_pagamentos.domain.model.Usuario;

public class AlterarStatusUsuarioUseCase {

    private final BuscarUsuarioIdUseCase buscarUsuarioIdUseCase;
    private final SalvarUsuarioUseCase salvarUsuarioUseCase;

    public AlterarStatusUsuarioUseCase(BuscarUsuarioIdUseCase buscarUsuarioIdUseCase, SalvarUsuarioUseCase salvarUsuarioUseCase) {
        this.buscarUsuarioIdUseCase = buscarUsuarioIdUseCase;
        this.salvarUsuarioUseCase = salvarUsuarioUseCase;
    }

    public Usuario alterarStatusUsuario(AlterarStatusUsuarioRequest alterarStatusUsuarioRequest){
        Usuario usuario = buscarUsuarioIdUseCase.buscarUsuarioId(alterarStatusUsuarioRequest.id());
        usuario.setStatusUsuario(alterarStatusUsuarioRequest.statusUsuario());
        return salvarUsuarioUseCase.salvarUsuario(usuario);
    }

}
