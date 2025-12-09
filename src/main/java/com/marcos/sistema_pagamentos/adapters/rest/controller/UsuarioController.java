package com.marcos.sistema_pagamentos.adapters.rest.controller;

import com.marcos.sistema_pagamentos.adapters.rest.dto.usuario.AlterarStatusUsuarioRequest;
import com.marcos.sistema_pagamentos.adapters.rest.dto.usuario.UsuarioRequest;
import com.marcos.sistema_pagamentos.adapters.rest.dto.usuario.UsuarioResponse;
import com.marcos.sistema_pagamentos.application.usecases.usuario.AlterarStatusUsuarioUseCase;
import com.marcos.sistema_pagamentos.application.usecases.usuario.CriarUsuarioUseCase;
import com.marcos.sistema_pagamentos.domain.model.Usuario;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final CriarUsuarioUseCase criarUsuarioUseCase;
    private final AlterarStatusUsuarioUseCase alterarStatusUsuarioUseCase;

    public UsuarioController(CriarUsuarioUseCase criarUsuarioUseCase, AlterarStatusUsuarioUseCase alterarStatusUsuarioUseCase) {
        this.criarUsuarioUseCase = criarUsuarioUseCase;
        this.alterarStatusUsuarioUseCase = alterarStatusUsuarioUseCase;
    }

    @PostMapping("/criar-usuario")
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody @Valid UsuarioRequest request){
        var usuarioCriado = criarUsuarioUseCase.criarUsuario(request);
        UsuarioResponse response = new UsuarioResponse(
                usuarioCriado.getId(),
                usuarioCriado.getNome(),
                usuarioCriado.getEmail(),
                usuarioCriado.getStatusUsuario()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/alterar-status")
    public ResponseEntity<UsuarioResponse> alterarStatus(@RequestBody @Valid AlterarStatusUsuarioRequest alterarStatusUsuarioRequest){
        Usuario usuario = alterarStatusUsuarioUseCase.alterarStatusUsuario(alterarStatusUsuarioRequest);
        UsuarioResponse response = new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getStatusUsuario()
        );
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
