package com.marcos.sistema_pagamentos.application.usecases.pagamento;

import com.marcos.sistema_pagamentos.application.usecases.usuario.BuscarUsuarioIdUseCase;
import com.marcos.sistema_pagamentos.domain.enumcls.StatusUsuario;
import com.marcos.sistema_pagamentos.domain.exceptions.StatusUsuarioException;
import com.marcos.sistema_pagamentos.domain.exceptions.ValorIlegalException;
import com.marcos.sistema_pagamentos.domain.model.Pagamento;
import com.marcos.sistema_pagamentos.domain.model.Usuario;
import com.marcos.sistema_pagamentos.domain.repository.pagamento.CriarPagamentoRepository;

import java.math.BigDecimal;

public class CriarPagamentoUseCase {

    private final CriarPagamentoRepository criarPagamentoRepository;
    private final BuscarUsuarioIdUseCase buscarUsuarioIdUseCase;

    public CriarPagamentoUseCase(CriarPagamentoRepository criarPagamentoRepository, BuscarUsuarioIdUseCase buscarUsuarioIdUseCase) {
        this.criarPagamentoRepository = criarPagamentoRepository;
        this.buscarUsuarioIdUseCase = buscarUsuarioIdUseCase;
    }

    public Pagamento criarPagamento(Long idUsuario, BigDecimal valor){

        if (valor.compareTo(BigDecimal.ZERO) <= 0){
            throw new ValorIlegalException("O valor da cobranca deve ser positivo");
        }

        Usuario usuario = buscarUsuarioIdUseCase.buscarUsuarioId(idUsuario);

        if (usuario.getStatusUsuario().equals(StatusUsuario.INATIVO)){
            throw new StatusUsuarioException("O usuario esta invativo");
        }

        Pagamento pagamento = new Pagamento(valor, usuario);

        return criarPagamentoRepository.criarPagamento(pagamento);
    }
}
