package com.marcos.sistema_pagamentos.infrastructure.persistence.jpa;

import com.marcos.sistema_pagamentos.infrastructure.persistence.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataUsuarioRepositoryJpa extends JpaRepository<UsuarioEntity, Long> {
    boolean existsByEmail(String email);
}
