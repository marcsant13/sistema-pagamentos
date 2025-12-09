package com.marcos.sistema_pagamentos.infrastructure.persistence.entity;

import com.marcos.sistema_pagamentos.domain.enumcls.StatusPagamento;
import com.marcos.sistema_pagamentos.domain.model.Usuario;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_pagamento")
public class PagamentoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private StatusPagamento statusPagamento;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuarioEntity;

    public PagamentoEntity() {
    }

    public PagamentoEntity(Long id, BigDecimal valor, StatusPagamento statusPagamento, UsuarioEntity usuarioEntity) {
        this.id = id;
        this.valor = valor;
        this.statusPagamento = statusPagamento;
        this.usuarioEntity = usuarioEntity;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
}
