package com.marcos.sistema_pagamentos.adapters.rest.dto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UsuarioRequest(
        @NotBlank(message = "preencha o campo 'nome'")
        String nome,
        @Email(message = "email invalido")
        String email,
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9]).{6,}$",
        message = "A senha deve ter no minimo 6 caracteres, com 1 letra maiuscula, 1 minuscula e 1 caractere especial")
        String senha
) {
}
