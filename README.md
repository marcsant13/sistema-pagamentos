# sistema-pagamentos
🧾 Gestão de Pagamentos

Este projeto é um sistema básico de gestão de pagamentos, desenvolvido com Spring Boot, JPA/Hibernate e PostgreSQL. Ele permite cadastrar usuários, registrar pagamentos e controlar seus status.

🚀 Tecnologias Utilizadas

Java 17+

Spring Boot

Spring Data JPA

PostgreSQL

Maven

Arquitetura baseada em camadas / Hexagonal (se aplicável ao seu projeto)

📌 Funcionalidades
👤 Usuários

Cadastro de novo usuário

Alterar status de ativo ➝ inativo e vice-versa

Listagem e consulta de usuários

💰 Pagamentos

Criar um pagamento vinculado a um usuário

Pagamentos podem ter os seguintes status:

PENDENTE

PAGO

CANCELADO

Listar pagamentos de um usuário

Obter o total pago por um usuário

🗄️ Banco de Dados

O sistema utiliza PostgreSQL.
As entidades principais são:

Usuário

Pagamento

O mapeamento entre as entidades é feito com Spring Data JPA.
