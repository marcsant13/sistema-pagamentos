package com.marcos.sistema_pagamentos.application.usecases.usuario;

import com.marcos.sistema_pagamentos.domain.model.Usuario;
import com.marcos.sistema_pagamentos.domain.repository.usuario.BuscarUsuarioIdRepository;

public class BuscarUsuarioIdUseCase {

    private final BuscarUsuarioIdRepository buscarUsuarioIdRepository;

    public BuscarUsuarioIdUseCase(BuscarUsuarioIdRepository buscarUsuarioIdRepository) {
        this.buscarUsuarioIdRepository = buscarUsuarioIdRepository;
    }

    public Usuario buscarUsuarioId(Long id){
        return buscarUsuarioIdRepository.buscarUsuarioPorId(id);
    }
}
