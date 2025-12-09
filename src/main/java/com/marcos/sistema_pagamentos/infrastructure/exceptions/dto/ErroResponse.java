package com.marcos.sistema_pagamentos.infrastructure.exceptions.dto;

import java.util.List;

public class ErroResponse {

    private String mensagem;
    private List<CamposErroResponse> erros;

    public ErroResponse(String mensagem, List<CamposErroResponse> erros) {
        this.mensagem = mensagem;
        this.erros = erros;
    }

    public String getMensagem() {
        return mensagem;
    }

    public List<CamposErroResponse> getErros() {
        return erros;
    }
}
