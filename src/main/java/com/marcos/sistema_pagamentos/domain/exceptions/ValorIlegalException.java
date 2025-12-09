package com.marcos.sistema_pagamentos.domain.exceptions;

public class ValorIlegalException extends RuntimeException{

    public ValorIlegalException(String message) {
        super(message);
    }
}
