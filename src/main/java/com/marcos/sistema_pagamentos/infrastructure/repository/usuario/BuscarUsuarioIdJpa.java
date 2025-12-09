package com.marcos.sistema_pagamentos.infrastructure.repository.usuario;

import com.marcos.sistema_pagamentos.domain.model.Pagamento;
import com.marcos.sistema_pagamentos.domain.model.Usuario;
import com.marcos.sistema_pagamentos.domain.repository.usuario.BuscarUsuarioIdRepository;
import com.marcos.sistema_pagamentos.infrastructure.persistence.entity.UsuarioEntity;
import com.marcos.sistema_pagamentos.infrastructure.persistence.jpa.SpringDataUsuarioRepositoryJpa;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BuscarUsuarioIdJpa implements BuscarUsuarioIdRepository {

    private final SpringDataUsuarioRepositoryJpa repositoryJpa;

    public BuscarUsuarioIdJpa(SpringDataUsuarioRepositoryJpa repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public Usuario buscarUsuarioPorId(Long id) {
        UsuarioEntity usuarioEntity = repositoryJpa.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuario nao encontrado"));

        List<Pagamento> pagamentos = usuarioEntity
                .getPagamentoEntities()
                .stream()
                .map(pagamentoEntity -> new Pagamento(
                        pagamentoEntity.getId(),
                        pagamentoEntity.getValor(),
                        pagamentoEntity.getStatusPagamento(),
                        new Usuario(
                                usuarioEntity.getId(),
                                usuarioEntity.getNome(),
                                usuarioEntity.getEmail(),
                                usuarioEntity.getSenha(),
                                usuarioEntity.getStatusUsuario()
                        )
                ))
                .toList();

        Usuario usuario = new Usuario(
                usuarioEntity.getId(),
                usuarioEntity.getNome(),
                usuarioEntity.getEmail(),
                usuarioEntity.getSenha(),
                usuarioEntity.getStatusUsuario(),
                pagamentos
        );
        return usuario;
    }
}
