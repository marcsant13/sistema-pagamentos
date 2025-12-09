package com.marcos.sistema_pagamentos.application.usecases.usuario;

import com.marcos.sistema_pagamentos.adapters.rest.dto.usuario.UsuarioRequest;
import com.marcos.sistema_pagamentos.domain.model.Usuario;
import com.marcos.sistema_pagamentos.domain.repository.usuario.CriarUsuarioRepository;
import jakarta.persistence.EntityExistsException;

public class CriarUsuarioUseCase {

    private final CriarUsuarioRepository criarUsuarioRepository;
    private final BuscarUsuarioEmailUseCase buscarUsuarioEmailUseCase;

    public CriarUsuarioUseCase(CriarUsuarioRepository criarUsuarioRepository, BuscarUsuarioEmailUseCase buscarUsuarioEmailUseCase) {
        this.criarUsuarioRepository = criarUsuarioRepository;
        this.buscarUsuarioEmailUseCase = buscarUsuarioEmailUseCase;
    }

    public Usuario criarUsuario(UsuarioRequest request){

        if (buscarUsuarioEmailUseCase.buscarUsuarioEmail(request.email())){
            throw new EntityExistsException("Ja existe usuario com esse email");
        }

        Usuario usuario = new Usuario(
                request.nome(),
                request.email(),
                request.senha()
        );

        return criarUsuarioRepository.criarUsuario(usuario);
    }
}
