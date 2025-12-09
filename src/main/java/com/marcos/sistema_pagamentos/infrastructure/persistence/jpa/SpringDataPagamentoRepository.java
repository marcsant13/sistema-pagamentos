package com.marcos.sistema_pagamentos.infrastructure.persistence.jpa;

import com.marcos.sistema_pagamentos.infrastructure.persistence.entity.PagamentoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;

public interface SpringDataPagamentoRepository extends JpaRepository<PagamentoEntity, Long> {

    @Query("SELECT SUM (p.valor) FROM PagamentoEntity p")
    BigDecimal totalPagamentos();

}
