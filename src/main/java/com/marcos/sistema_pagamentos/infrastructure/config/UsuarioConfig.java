package com.marcos.sistema_pagamentos.infrastructure.config;

import com.marcos.sistema_pagamentos.application.usecases.pagamento.CriarPagamentoUseCase;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.ListarPagamentosUseCase;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.SomaPagamentosUsuarioUseCase;
import com.marcos.sistema_pagamentos.application.usecases.pagamento.SomaTotalPagamentoUseCase;
import com.marcos.sistema_pagamentos.application.usecases.usuario.*;
import com.marcos.sistema_pagamentos.domain.repository.pagamento.CriarPagamentoRepository;
import com.marcos.sistema_pagamentos.domain.repository.pagamento.SomaTotalPagamentoRepository;
import com.marcos.sistema_pagamentos.domain.repository.usuario.BuscarUsuarioEmailRepository;
import com.marcos.sistema_pagamentos.domain.repository.usuario.BuscarUsuarioIdRepository;
import com.marcos.sistema_pagamentos.domain.repository.usuario.CriarUsuarioRepository;
import com.marcos.sistema_pagamentos.domain.repository.usuario.SalvarUsuarioRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UsuarioConfig {

    @Bean
    public CriarUsuarioUseCase criarUsuarioUseCase(
            CriarUsuarioRepository criarUsuarioRepository,
            BuscarUsuarioEmailUseCase buscarUsuarioEmailUseCase){
        return new CriarUsuarioUseCase(criarUsuarioRepository, buscarUsuarioEmailUseCase);
    }

    @Bean
    public BuscarUsuarioIdUseCase buscarUsuarioIdUseCase(BuscarUsuarioIdRepository buscarUsuarioIdRepository){
        return new BuscarUsuarioIdUseCase(buscarUsuarioIdRepository);
    }

    @Bean
    public SalvarUsuarioUseCase salvarUsuarioUseCase(SalvarUsuarioRepository salvarUsuarioRepository){
        return new SalvarUsuarioUseCase(salvarUsuarioRepository);
    }

    @Bean
    public AlterarStatusUsuarioUseCase alterarStatusUsuarioUseCase(
            BuscarUsuarioIdUseCase buscarUsuarioIdUseCase,
            SalvarUsuarioUseCase salvarUsuarioUseCase
    ){
        return new AlterarStatusUsuarioUseCase(buscarUsuarioIdUseCase, salvarUsuarioUseCase);
    }

    @Bean
    public BuscarUsuarioEmailUseCase buscarUsuarioEmailUseCase(BuscarUsuarioEmailRepository buscarUsuarioEmailRepository){
        return new BuscarUsuarioEmailUseCase(buscarUsuarioEmailRepository);
    }

}
