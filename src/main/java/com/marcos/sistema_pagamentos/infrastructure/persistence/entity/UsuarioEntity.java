package com.marcos.sistema_pagamentos.infrastructure.persistence.entity;

import com.marcos.sistema_pagamentos.domain.enumcls.StatusUsuario;
import com.marcos.sistema_pagamentos.domain.model.Pagamento;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private StatusUsuario statusUsuario;

    @OneToMany(mappedBy = "usuarioEntity", fetch = FetchType.LAZY)
    private List<PagamentoEntity> pagamentoEntities;

    public UsuarioEntity() { }

    public UsuarioEntity(Long id, String nome, String email, String senha, StatusUsuario statusUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.statusUsuario = statusUsuario;
    }

    public UsuarioEntity(Long id, String nome, String email, String senha, StatusUsuario statusUsuario, List<PagamentoEntity> pagamentoEntities) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.statusUsuario = statusUsuario;
        this.pagamentoEntities = pagamentoEntities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public StatusUsuario getStatusUsuario() {
        return statusUsuario;
    }

    public void setStatusUsuario(StatusUsuario statusUsuario) {
        this.statusUsuario = statusUsuario;
    }

    public List<PagamentoEntity> getPagamentoEntities() {
        return pagamentoEntities;
    }

    public void setPagamentoEntities(List<PagamentoEntity> pagamentoEntities) {
        this.pagamentoEntities = pagamentoEntities;
    }
}
