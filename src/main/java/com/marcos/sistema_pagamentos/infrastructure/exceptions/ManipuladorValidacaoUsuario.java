package com.marcos.sistema_pagamentos.infrastructure.exceptions;

import com.marcos.sistema_pagamentos.domain.exceptions.StatusUsuarioException;
import com.marcos.sistema_pagamentos.domain.exceptions.ValorIlegalException;
import com.marcos.sistema_pagamentos.infrastructure.exceptions.dto.CamposErroResponse;
import com.marcos.sistema_pagamentos.infrastructure.exceptions.dto.ErroResponse;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.ValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ManipuladorValidacaoUsuario {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErroResponse> lidarErrosValidacao(MethodArgumentNotValidException exception){
        List<CamposErroResponse> camposErros = exception.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(erro -> new CamposErroResponse(erro.getField(), erro.getDefaultMessage()))
                .toList();

        ErroResponse response = new ErroResponse(
                "Erro de validacao",
                camposErros
        );

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroResponse> lidarErroBuscaUsuario(EntityNotFoundException exception){
        List<CamposErroResponse> camposErros = new ArrayList<>();
        CamposErroResponse camposErroResponse = new CamposErroResponse("", exception.getMessage());
        camposErros.add(camposErroResponse);

        ErroResponse response = new ErroResponse(
                "Erro de busca",
                camposErros
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity<ErroResponse> lidarErroBuscaUsuarioEmail(EntityExistsException exception){
        List<CamposErroResponse> camposErros = new ArrayList<>();
        CamposErroResponse camposErroResponse = new CamposErroResponse("", exception.getMessage());
        camposErros.add(camposErroResponse);

        ErroResponse response = new ErroResponse(
                "Usuario existente",
                camposErros
        );

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ExceptionHandler(ValorIlegalException.class)
    public ResponseEntity<ErroResponse> lidarErroValorPagamento(ValorIlegalException exception){
        List<CamposErroResponse> camposErros = new ArrayList<>();
        CamposErroResponse camposErroResponse = new CamposErroResponse("", exception.getMessage());
        camposErros.add(camposErroResponse);

        ErroResponse response = new ErroResponse(
                "Valor invalido",
                camposErros
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(StatusUsuarioException.class)
    public ResponseEntity<ErroResponse> lidarErroStatusUsuario(StatusUsuarioException exception){
        List<CamposErroResponse> camposErros = new ArrayList<>();
        CamposErroResponse camposErroResponse = new CamposErroResponse("", exception.getMessage());
        camposErros.add(camposErroResponse);

        ErroResponse response = new ErroResponse(
                "Status de Usuario Invalido",
                camposErros
        );

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
