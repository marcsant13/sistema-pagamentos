package com.marcos.sistema_pagamentos.infrastructure.config;

import com.marcos.sistema_pagamentos.application.usecases.pagamento.CriarPagamentoUseCase;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.ListarPagamentosUseCase;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.SomaPagamentosUsuarioUseCase;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.SomaTotalPagamentoUseCase;
import com.marcos.sistema_pagamentos.application.usecases.usuario.BuscarUsuarioIdUseCase;
import com.marcos.sistema_pagamentos.domain.repository.pagamento.CriarPagamentoRepository;
import com.marcos.sistema_pagamentos.domain.repository.pagamento.SomaTotalPagamentoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PagamentoConfig {

    @Bean
    public CriarPagamentoUseCase criarPagamentoUseCase(
            CriarPagamentoRepository criarPagamentoRepository,
            BuscarUsuarioIdUseCase buscarUsuarioIdUseCase)
    {
        return new CriarPagamentoUseCase(criarPagamentoRepository, buscarUsuarioIdUseCase);
    }

    @Bean
    public ListarPagamentosUseCase listarPagamentosUseCase(BuscarUsuarioIdUseCase buscarUsuarioIdUseCase){
        return new ListarPagamentosUseCase(buscarUsuarioIdUseCase);
    }

    @Bean
    public SomaPagamentosUsuarioUseCase somaPagamentosUseCase(BuscarUsuarioIdUseCase buscarUsuarioIdUseCase){
        return new SomaPagamentosUsuarioUseCase(buscarUsuarioIdUseCase);
    }

    @Bean
    public SomaTotalPagamentoUseCase somaTotalPagamentoUseCase(SomaTotalPagamentoRepository somaTotalPagamentoRepository){
        return new SomaTotalPagamentoUseCase(somaTotalPagamentoRepository);
    }

}
