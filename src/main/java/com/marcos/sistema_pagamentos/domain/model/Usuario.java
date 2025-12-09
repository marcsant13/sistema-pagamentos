package com.marcos.sistema_pagamentos.domain.model;

import com.marcos.sistema_pagamentos.domain.enumcls.StatusUsuario;

import java.util.List;

public class Usuario {

    private Long id;
    private String nome;
    private String email;
    private String senha;
    private StatusUsuario statusUsuario;
    private List<Pagamento> pagamentos;

    public Usuario(String nome, String email, String senha) {
        criarStatusUsuario();
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario(Long id, String nome, String email, String senha, StatusUsuario statusUsuario) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.statusUsuario = statusUsuario;
    }

    public Usuario(Long id, String nome, String email, String senha, StatusUsuario statusUsuario, List<Pagamento> pagamentos) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.statusUsuario = statusUsuario;
        this.pagamentos = pagamentos;
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public StatusUsuario criarStatusUsuario(){
        return this.statusUsuario = StatusUsuario.ATIVO;
    }

    public List<Pagamento> getPagamentos() { return pagamentos; }
}
