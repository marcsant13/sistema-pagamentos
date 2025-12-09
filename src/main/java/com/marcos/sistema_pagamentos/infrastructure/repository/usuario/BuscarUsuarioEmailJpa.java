package com.marcos.sistema_pagamentos.infrastructure.repository.usuario;

import com.marcos.sistema_pagamentos.domain.repository.usuario.BuscarUsuarioEmailRepository;
import com.marcos.sistema_pagamentos.infrastructure.persistence.jpa.SpringDataUsuarioRepositoryJpa;
import org.springframework.stereotype.Repository;

@Repository
public class BuscarUsuarioEmailJpa implements BuscarUsuarioEmailRepository {

    private final SpringDataUsuarioRepositoryJpa springDataUsuarioRepositoryJpa;

    public BuscarUsuarioEmailJpa(SpringDataUsuarioRepositoryJpa springDataUsuarioRepositoryJpa) {
        this.springDataUsuarioRepositoryJpa = springDataUsuarioRepositoryJpa;
    }

    @Override
    public boolean buscarUsuarioEmail(String email) {
        return springDataUsuarioRepositoryJpa.existsByEmail(email);
    }
}
