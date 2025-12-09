package com.marcos.sistema_pagamentos.application.usecases.pagamento;

import com.marcos.sistema_pagamentos.domain.repository.pagamento.SomaTotalPagamentoRepository;

import java.math.BigDecimal;

public class SomaTotalPagamentoUseCase {

    private final SomaTotalPagamentoRepository somaTotalPagamentoRepository;

    public SomaTotalPagamentoUseCase(SomaTotalPagamentoRepository somaTotalPagamentoRepository) {
        this.somaTotalPagamentoRepository = somaTotalPagamentoRepository;
    }

    public BigDecimal somaTotalPagamento(){
        return somaTotalPagamentoRepository.somaTotal();
    }
}
