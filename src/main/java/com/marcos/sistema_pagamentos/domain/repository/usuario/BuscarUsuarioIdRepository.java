package com.marcos.sistema_pagamentos.domain.repository.usuario;

import com.marcos.sistema_pagamentos.domain.model.Usuario;

public interface BuscarUsuarioIdRepository {
    Usuario buscarUsuarioPorId(Long id);
}
