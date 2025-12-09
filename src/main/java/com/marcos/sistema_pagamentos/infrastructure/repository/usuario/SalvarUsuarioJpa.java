package com.marcos.sistema_pagamentos.infrastructure.repository.usuario;

import com.marcos.sistema_pagamentos.domain.model.Usuario;
import com.marcos.sistema_pagamentos.domain.repository.usuario.SalvarUsuarioRepository;
import com.marcos.sistema_pagamentos.infrastructure.persistence.entity.UsuarioEntity;
import com.marcos.sistema_pagamentos.infrastructure.persistence.jpa.SpringDataUsuarioRepositoryJpa;
import org.springframework.stereotype.Repository;

@Repository
public class SalvarUsuarioJpa implements SalvarUsuarioRepository {

    private final SpringDataUsuarioRepositoryJpa repositoryJpa;

    public SalvarUsuarioJpa(SpringDataUsuarioRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public Usuario salvarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getStatusUsuario()
        );
        repositoryJpa.save(usuarioEntity);
        return usuario;
    }
}
