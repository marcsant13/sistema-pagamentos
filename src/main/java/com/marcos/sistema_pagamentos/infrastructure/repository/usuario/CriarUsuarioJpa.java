package com.marcos.sistema_pagamentos.infrastructure.repository.usuario;

import com.marcos.sistema_pagamentos.domain.model.Usuario;
import com.marcos.sistema_pagamentos.domain.repository.usuario.CriarUsuarioRepository;
import com.marcos.sistema_pagamentos.infrastructure.persistence.entity.UsuarioEntity;
import com.marcos.sistema_pagamentos.infrastructure.persistence.jpa.SpringDataUsuarioRepositoryJpa;
import org.springframework.stereotype.Repository;

@Repository
public class CriarUsuarioJpa implements CriarUsuarioRepository {

    private final SpringDataUsuarioRepositoryJpa repositoryJpa;

    public CriarUsuarioJpa(SpringDataUsuarioRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public Usuario criarUsuario(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(
                null,
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getSenha(),
                usuario.getStatusUsuario()
        );
        repositoryJpa.save(usuarioEntity);
        return new Usuario(
                usuarioEntity.getId(),
                usuarioEntity.getNome(),
                usuarioEntity.getEmail(),
                usuarioEntity.getSenha(),
                usuarioEntity.getStatusUsuario()
        );
    }

}
