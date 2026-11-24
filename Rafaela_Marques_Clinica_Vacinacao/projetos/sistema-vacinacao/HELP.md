# Sistema de Controle de Clínica de Vacinação

Projeto desenvolvido por Rafaela Marques para a atividade de recuperação de Banco de Dados.

## Tecnologias

- Java
- Spring Boot
- Spring Data JPA
- Thymeleaf
- H2 Database
- Maven

## Executar

No terminal, dentro da pasta `sistema-vacinacao`, execute:

```cmd
mvnw.cmd spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080/`.

## Banco de dados

O script MySQL da atividade está em `clinica_vacinacao.sql`.
O sistema utiliza três entidades relacionadas: Paciente, Vacina e Agendamento.
