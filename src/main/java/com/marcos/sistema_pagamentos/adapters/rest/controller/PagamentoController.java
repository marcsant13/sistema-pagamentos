package com.marcos.sistema_pagamentos.adapters.rest.controller;

import com.marcos.sistema_pagamentos.adapters.rest.dto.pagamento.CriarPagamentoResponse;
import com.marcos.sistema_pagamentos.adapters.rest.dto.pagamento.ListarPagamentosResponse;
import com.marcos.sistema_pagamentos.adapters.rest.dto.usuario.UsuarioResponse;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.CriarPagamentoUseCase;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.ListarPagamentosUseCase;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.SomaPagamentosUsuarioUseCase;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.SomaTotalPagamentoUseCase;
import com.marcos.sistema_pagamentos.domain.model.Pagamento;
import com.marcos.sistema_pagamentos.domain.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {

    private final CriarPagamentoUseCase criarPagamentoUseCase;
    private final ListarPagamentosUseCase listarPagamentosUseCase;
    private final SomaPagamentosUsuarioUseCase somaPagamentosUsuarioUseCase;
    private final SomaTotalPagamentoUseCase somaTotalPagamentoUseCase;

    public PagamentoController(CriarPagamentoUseCase criarPagamentoUseCase, ListarPagamentosUseCase listarPagamentosUseCase, SomaPagamentosUsuarioUseCase somaPagamentosUsuarioUseCase, SomaTotalPagamentoUseCase somaTotalPagamentoUseCase) {
        this.criarPagamentoUseCase = criarPagamentoUseCase;
        this.listarPagamentosUseCase = listarPagamentosUseCase;
        this.somaPagamentosUsuarioUseCase = somaPagamentosUsuarioUseCase;
        this.somaTotalPagamentoUseCase = somaTotalPagamentoUseCase;
    }

    @PostMapping("/criar-pagamento/{idUsuario}/{valor}")
    public ResponseEntity<CriarPagamentoResponse> criarPagamento(@PathVariable Long idUsuario, @PathVariable BigDecimal valor){
        Pagamento pagamento = criarPagamentoUseCase.criarPagamento(idUsuario, valor);
        CriarPagamentoResponse response = new CriarPagamentoResponse(
                pagamento.getId(),
                pagamento.getValor(),
                pagamento.getStatusPagamento()
        );
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/listar-pagamentos/{idUsuario}")
    public ResponseEntity<ListarPagamentosResponse> listarPagamentosUsuario(@PathVariable Long idUsuario){

        Usuario usuario = listarPagamentosUseCase.listarPagamentos(idUsuario);

        List<CriarPagamentoResponse> list = usuario.getPagamentos().stream().map(pagamento -> new CriarPagamentoResponse(
                pagamento.getId(),
                pagamento.getValor(),
                pagamento.getStatusPagamento()
        )).toList();

        BigDecimal total = somaPagamentosUsuarioUseCase.somaPagamentos(idUsuario);

        UsuarioResponse usuarioResponse = new UsuarioResponse(
                usuario.getId(),
                usuario.getNome(),
                usuario.getEmail(),
                usuario.getStatusUsuario()
        );

        ListarPagamentosResponse listarPagamentosResponse = new ListarPagamentosResponse(
                usuarioResponse,
                list,
                total
        );

        return ResponseEntity.status(HttpStatus.OK).body(listarPagamentosResponse);
    }

    @GetMapping("/soma-total")
    public ResponseEntity<BigDecimal> somaTotalPagamento(){
        return ResponseEntity.status(HttpStatus.OK).body(somaTotalPagamentoUseCase.somaTotalPagamento());
    }
}
