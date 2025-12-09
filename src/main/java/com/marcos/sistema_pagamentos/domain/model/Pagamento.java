package com.marcos.sistema_pagamentos.domain.model;

import com.marcos.sistema_pagamentos.domain.enumcls.StatusPagamento;

import java.math.BigDecimal;

public class Pagamento {

    private Long id;
    private BigDecimal valor;
    private StatusPagamento statusPagamento;
    private Usuario usuario;

    public Pagamento(BigDecimal valor, Usuario usuario) {
        setStatusPagamento(StatusPagamento.PENDENTE);
        this.valor = valor;
        this.usuario = usuario;
    }

    public Pagamento(Long id, BigDecimal valor, StatusPagamento statusPagamento, Usuario usuario) {
        this.id = id;
        this.valor = valor;
        this.statusPagamento = statusPagamento;
        this.usuario = usuario;
    }

    public Pagamento(Long id, BigDecimal valor, StatusPagamento statusPagamento) {
        this.id = id;
        this.valor = valor;
        this.statusPagamento = statusPagamento;
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public StatusPagamento getStatusPagamento() {
        return statusPagamento;
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

}
