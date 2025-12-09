package com.marcos.sistema_pagamentos.infrastructure.repository.pagamento;

import com.marcos.sistema_pagamentos.domain.model.Pagamento;
import com.marcos.sistema_pagamentos.domain.model.Usuario;
import com.marcos.sistema_pagamentos.domain.repository.pagamento.CriarPagamentoRepository;
import com.marcos.sistema_pagamentos.infrastructure.persistence.entity.PagamentoEntity;
import com.marcos.sistema_pagamentos.infrastructure.persistence.entity.UsuarioEntity;
import com.marcos.sistema_pagamentos.infrastructure.persistence.jpa.SpringDataPagamentoRepository;
import com.marcos.sistema_pagamentos.infrastructure.persistence.jpa.SpringDataUsuarioRepositoryJpa;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.parser.Entity;
import java.math.BigDecimal;

@Repository
public class CriarPagamentoJpa implements CriarPagamentoRepository {

    private final SpringDataPagamentoRepository pagamentoRepository;
    private final SpringDataUsuarioRepositoryJpa usuarioRepository;

    public CriarPagamentoJpa(SpringDataPagamentoRepository pagamentoRepository, SpringDataUsuarioRepositoryJpa usuarioRepository) {
        this.pagamentoRepository = pagamentoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Pagamento criarPagamento(Pagamento pagamento) {
        UsuarioEntity usuarioEntity = usuarioRepository.findById(pagamento.getUsuario().getId()).get();

        PagamentoEntity pagamentoEntity = pagamentoRepository.save(new PagamentoEntity(
                null,
                pagamento.getValor(),
                pagamento.getStatusPagamento(),
                usuarioEntity
        ));

        return new Pagamento(
                pagamentoEntity.getId(),
                pagamentoEntity.getValor(),
                pagamentoEntity.getStatusPagamento()
        );
    }
}
