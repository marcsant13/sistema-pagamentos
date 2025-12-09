package com.marcos.sistema_pagamentos.application.usecases.usuario;

import com.marcos.sistema_pagamentos.domain.model.Usuario;
import com.marcos.sistema_pagamentos.domain.repository.usuario.SalvarUsuarioRepository;

public class SalvarUsuarioUseCase {

    private final SalvarUsuarioRepository salvarUsuarioRepository;

    public SalvarUsuarioUseCase(SalvarUsuarioRepository salvarUsuarioRepository) {
        this.salvarUsuarioRepository = salvarUsuarioRepository;
    }

    public Usuario salvarUsuario(Usuario usuario){
        return salvarUsuarioRepository.salvarUsuario(usuario);
    }
}
