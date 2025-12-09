package com.marcos.sistema_pagamentos.adapters.rest.dto.pagamento;

import com.marcos.sistema_pagamentos.domain.enumcls.StatusPagamento;

import java.math.BigDecimal;

public record CriarPagamentoResponse(
        Long id,
        BigDecimal valor,
        StatusPagamento statusPagamento
) {
}
