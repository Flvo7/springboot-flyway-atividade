Clientes API

Este projeto é uma API RESTful para o cadastro e gerenciamento de clientes, construída utilizando Spring Boot, PostgreSQL, Flyway. Ele segue boas práticas de programação e utiliza estruturação em camadas (Controller, Service, Repository) para melhor organização.


---

Configuração do Ambiente

Requisitos

Java 17 (OpenJDK ou Oracle JDK)

Maven 3.8+

PostgreSQL 12+

Ferramenta de edição de código (opcional): IntelliJ IDEA, VSCode, ou outra de sua preferência.


Passos para Configuração

1. Clone o repositório

Execute os comandos abaixo para clonar o projeto:

git clone https://github.com/seu-usuario/spring-clientes.git
cd spring-clientes

2. Configure o Banco de Dados

1. Acesse seu banco PostgreSQL e crie o banco de dados:

CREATE DATABASE clientes_db;


2. Configure as credenciais de acesso no arquivo src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/clientes_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=none
spring.flyway.enabled=true



3. Compile o projeto

Execute o comando para baixar dependências e compilar o projeto:

mvn clean install

4. Execute a aplicação

Inicie o servidor:

mvn spring-boot:run

5. Acesse a API

A API estará disponível em:

http://localhost:8080/api/clientes


---

Estrutura do Projeto

Model: Define a classe Cliente com os atributos id, nome, email e telefone.

Repository: Interface que permite interação com o banco de dados usando JPA.

Service: Camada que encapsula a lógica de negócios.

Controller: Gerencia os endpoints REST para operações de CRUD.

Flyway: Gerencia o versionamento do banco de dados.



---

Endpoints Disponíveis

1. Listar todos os clientes

Método: GET

Endpoint: /api/clientes

Descrição: Retorna uma lista de todos os clientes cadastrados.

Exemplo de Uso (cURL):

curl -X GET http://localhost:8080/api/clientes



---

2. Buscar um cliente por ID

Método: GET

Endpoint: /api/clientes/{id}

Descrição: Retorna os dados de um cliente específico.

Exemplo de Uso (cURL):

curl -X GET http://localhost:8080/api/clientes/1



---

3. Criar um novo cliente

Método: POST

Endpoint: /api/clientes

Descrição: Adiciona um novo cliente ao banco de dados.

Exemplo de Body:

{
  "nome": "João Silva",
  "email": "joao.silva@example.com",
  "telefone": "(62) 91234-5678"
}

Exemplo de Uso (cURL):

curl -X POST http://localhost:8080/api/clientes \
-H "Content-Type: application/json" \
-d '{"nome": "João Silva", "email": "joao.silva@example.com", "telefone": "(62) 91234-5678"}'



---

4. Atualizar um cliente existente

Método: PUT

Endpoint: /api/clientes/{id}

Descrição: Atualiza os dados de um cliente específico.

Exemplo de Body:

{
  "nome": "João Pereira",
  "email": "joao.pereira@example.com",
  "telefone": "(62) 99876-5432"
}

Exemplo de Uso (cURL):

curl -X PUT http://localhost:8080/api/clientes/1 \
-H "Content-Type: application/json" \
-d '{"nome": "João Pereira", "email": "joao.pereira@example.com", "telefone": "(62) 99876-5432"}'



---

5. Deletar um cliente

Método: DELETE

Endpoint: /api/clientes/{id}

Descrição: Remove um cliente do banco de dados.

Exemplo de Uso (cURL):

curl -X DELETE http://localhost:8080/api/clientes/1



---

Versionamento do Banco de Dados

Este projeto utiliza o Flyway para gerenciar o versionamento do banco de dados. Os scripts SQL de migração estão localizados na pasta src/main/resources/db/migration. Abaixo está um exemplo do script usado para criar a tabela clientes:

-- V1__Create_Clientes_Table.sql
CREATE TABLE cliente (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(15) NOT NULL
);

Para aplicar as migrações, basta executar a aplicação. O Flyway fará o versionamento automaticamente ao iniciar.


---

Dependências Utilizadas

Spring Boot 3.1.6:

spring-boot-starter-web: Para criação da API REST.

spring-boot-starter-data-jpa: Para integração com o banco de dados.


PostgreSQL 42.2.23: Driver de conexão com o banco PostgreSQL.

Flyway 9.22.1: Para versionamento do banco de dados.

Maven 3.8+: Gerenciador de dependências e build.



---

Como Contribuir

1. Faça um fork do repositório.


2. Crie uma branch para a sua feature:

git checkout -b minha-feature


3. Faça as alterações e commit:

git commit -m "Adicionei uma nova feature"


4. Envie o pull request.
