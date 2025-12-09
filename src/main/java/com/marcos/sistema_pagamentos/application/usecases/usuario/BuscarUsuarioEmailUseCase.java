package com.marcos.sistema_pagamentos.application.usecases.usuario;

import com.marcos.sistema_pagamentos.domain.repository.usuario.BuscarUsuarioEmailRepository;

public class BuscarUsuarioEmailUseCase {

    private final BuscarUsuarioEmailRepository buscarUsuarioEmailRepository;

    public BuscarUsuarioEmailUseCase(BuscarUsuarioEmailRepository buscarUsuarioEmailRepository) {
        this.buscarUsuarioEmailRepository = buscarUsuarioEmailRepository;
    }

    public boolean buscarUsuarioEmail(String email) {
        return buscarUsuarioEmailRepository.buscarUsuarioEmail(email);
    }
}
