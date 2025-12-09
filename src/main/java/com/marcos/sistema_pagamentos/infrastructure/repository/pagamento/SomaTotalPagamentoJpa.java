package com.marcos.sistema_pagamentos.infrastructure.repository.pagamento;

import com.marcos.sistema_pagamentos.domain.repository.pagamento.SomaTotalPagamentoRepository;
import com.marcos.sistema_pagamentos.infrastructure.persistence.jpa.SpringDataPagamentoRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class SomaTotalPagamentoJpa implements SomaTotalPagamentoRepository {

    private final SpringDataPagamentoRepository repositoryJpa;

    public SomaTotalPagamentoJpa(SpringDataPagamentoRepository repositoryJpa) {
        this.repositoryJpa = repositoryJpa;
    }

    @Override
    public BigDecimal somaTotal() {
        return repositoryJpa.totalPagamentos();
    }
}
