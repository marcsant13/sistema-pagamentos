package com.marcos.sistema_pagamentos.application.usecases.pagamento;

import com.marcos.sistema_pagamentos.application.usecases.usuario.BuscarUsuarioIdUseCase;
import com.marcos.sistema_pagamentos.domain.model.Pagamento;
import com.marcos.sistema_pagamentos.domain.model.Usuario;

import java.math.BigDecimal;

public class SomaPagamentosUsuarioUseCase {

    private final BuscarUsuarioIdUseCase buscarUsuarioIdUseCase;

    public SomaPagamentosUsuarioUseCase(BuscarUsuarioIdUseCase buscarUsuarioIdUseCase) {
        this.buscarUsuarioIdUseCase = buscarUsuarioIdUseCase;
    }

    public BigDecimal somaPagamentos(Long idUsuario){
        Usuario usuario = buscarUsuarioIdUseCase.buscarUsuarioId(idUsuario);
        return usuario
                .getPagamentos()
                .stream()
                .map(Pagamento::getValor)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
