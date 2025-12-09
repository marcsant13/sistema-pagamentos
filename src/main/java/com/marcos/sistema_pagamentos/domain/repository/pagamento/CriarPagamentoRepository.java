package com.marcos.sistema_pagamentos.domain.repository.pagamento;

import com.marcos.sistema_pagamentos.domain.model.Pagamento;
import com.marcos.sistema_pagamentos.domain.model.Usuario;

import java.math.BigDecimal;

public interface CriarPagamentoRepository {
    Pagamento criarPagamento(Pagamento pagamento);
}
