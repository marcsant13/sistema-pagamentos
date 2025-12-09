package com.marcos.sistema_pagamentos.adapters.rest.dto.pagamento;


import com.marcos.sistema_pagamentos.adapters.rest.dto.usuario.UsuarioResponse;

import java.math.BigDecimal;
import java.util.List;

public record ListarPagamentosResponse(
        UsuarioResponse usuarioResponse,
        List<CriarPagamentoResponse> pagamentoResponse,
        BigDecimal total
) {
}
