package com.marcos.sistema_pagamentos.infrastructure.exceptions.dto;

public class CamposErroResponse {

    private String campo;
    private String erro;

    public CamposErroResponse(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

}
