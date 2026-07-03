# API - Gerenciamento de Beneficiários e Documentos

Projeto desenvolvido para revisão e prática de desenvolvimento de APIs REST utilizando Java e Spring Boot.

A aplicação permite o gerenciamento de beneficiários e seus documentos, implementando operações CRUD, relacionamento entre entidades e boas práticas de organização em camadas.

## Objetivo

Este projeto foi desenvolvido durante meus estudos de Java e Spring Boot para reforçar conceitos importantes do ecossistema Java Backend, como:

- Construção de APIs REST
- Arquitetura em camadas
- Spring Boot
- Spring Data JPA
- Hibernate
- Relacionamento entre entidades
- Persistência de dados
- Validação de requisições
- Organização de código

## Tecnologias

- Java 21
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- Maven
- Banco de dados H2
- Lombok

## Funcionalidades

### Beneficiários

- Criar beneficiário
- Buscar beneficiário por ID
- Atualizar beneficiário
- Remover beneficiário
- Listar beneficiários

### Documentos

- Adicionar documentos a um beneficiário
- Listar documentos de um beneficiário
- Marcar documento principal
- Remover documentos

## Estrutura do Projeto

```
src
 ├── controller
 ├── service
 ├── repository
 ├── model
 ├── dto
 ├── exception
 └── config
```

A arquitetura segue a separação de responsabilidades entre Controller, Service e Repository, padrão amplamente utilizado em aplicações Spring Boot.

## Como executar

### Clonar o projeto

```bash
git clone https://github.com/salles97/Desafio-API-JAVA-Beneficiarios-e-documentos.git
```

### Entrar na pasta

```bash
cd Desafio-API-JAVA-Beneficiarios-e-documentos
```

### Executar

```bash
./mvnw spring-boot:run
```

ou

```bash
mvn spring-boot:run
```

A aplicação será iniciada em:

```
http://localhost:8080
```

## Banco de dados

O projeto utiliza o banco H2 em memória.

Caso o console esteja habilitado:

```
http://localhost:8080/h2-console
```

## Endpoints

| Método | Endpoint | Descrição |
|---------|----------|-----------|
| POST | /beneficiarios | Criar beneficiário |
| GET | /beneficiarios | Listar beneficiários |
| GET | /beneficiarios/{id} | Buscar beneficiário |
| PUT | /beneficiarios/{id} | Atualizar beneficiário |
| DELETE | /beneficiarios/{id} | Remover beneficiário |
| POST | /documentos | Criar documento |
| GET | /documentos/{id} | Buscar documento |

> Os endpoints podem variar conforme a implementação realizada.

## Aprendizados

Durante o desenvolvimento deste projeto foram praticados conceitos como:

- Programação Orientada a Objetos
- Injeção de Dependência
- Inversão de Controle (IoC)
- API REST
- CRUD
- Relacionamentos OneToMany e ManyToOne
- DTOs
- Tratamento de exceções
- Persistência com JPA/Hibernate

## Melhorias futuras

- Testes unitários com JUnit e Mockito
- Spring Security + JWT
- Swagger/OpenAPI
- Docker
- PostgreSQL
- Paginação
- Filtros de busca
- CI/CD com GitHub Actions

## Autor

**Gustavo Salles**

- LinkedIn: https://linkedin.com/in/sallesdev
- GitHub: https://github.com/salles97
