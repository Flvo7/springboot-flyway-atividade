Carro API

Este projeto é uma API RESTful para o cadastro de carros. Foi desenvolvido utilizando Spring Boot, PostgreSQL, Flyway e outras tecnologias para demonstrar boas práticas de programação, versionamento de banco de dados e estruturação em camadas.


---

Configuração do Ambiente

Requisitos

Java 17 (OpenJDK ou Oracle JDK)

Maven 3.8+

PostgreSQL 12+

Um editor de código, como IntelliJ IDEA ou VSCode (opcional).


Passos para Configurar

1. Clone o Repositório:

git clone https://github.com/seu-usuario/spring-cars.git
cd spring-cars


2. Configure o Banco de Dados:

Crie um banco de dados no PostgreSQL:

CREATE DATABASE carros_db;

Configure as credenciais de acesso no arquivo src/main/resources/application.properties:

spring.datasource.url=jdbc:postgresql://localhost:5432/carros_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=none
spring.flyway.enabled=true



3. Compile e Execute o Projeto:

Compile o projeto:

mvn clean install

Execute a aplicação:

mvn spring-boot:run



4. Acesse a API:

Após iniciar, a API estará disponível em:

http://localhost:8080/api/carros





---

Endpoints e Exemplos de Uso

Aqui estão os principais endpoints disponíveis e exemplos de como utilizá-los via cURL:

1. Listar todos os carros

Endpoint: GET /api/carros

Exemplo:

curl -X GET http://localhost:8080/api/carros


2. Buscar um carro por placa

Endpoint: GET /api/carros/{placa}

Exemplo:

curl -X GET http://localhost:8080/api/carros/ABC1234


3. Criar um novo carro

Endpoint: POST /api/carros

Body:

{
  "placa": "DEF5678",
  "nome": "Onix",
  "marca": "Chevrolet"
}

Exemplo:

curl -X POST http://localhost:8080/api/carros \
-H "Content-Type: application/json" \
-d '{"placa": "DEF5678", "nome": "Onix", "marca": "Chevrolet"}'


4. Atualizar os dados de um carro

Endpoint: PUT /api/carros/{placa}

Body:

{
  "nome": "Onix Plus",
  "marca": "Chevrolet"
}

Exemplo:

curl -X PUT http://localhost:8080/api/carros/DEF5678 \
-H "Content-Type: application/json" \
-d '{"nome": "Onix Plus", "marca": "Chevrolet"}'


5. Deletar um carro

Endpoint: DELETE /api/carros/{placa}

Exemplo:

curl -X DELETE http://localhost:8080/api/carros/DEF5678



---

Dependências Utilizadas

As principais dependências utilizadas neste projeto são:

Spring Boot 3.1.6:

spring-boot-starter-web: Para criar a API RESTful.

spring-boot-starter-data-jpa: Para integração com o banco de dados.


PostgreSQL 42.2.23: Driver de conexão com o banco de dados PostgreSQL.

Flyway 9.22.1: Para versionamento do banco de dados.

Maven 3.8+: Para gerenciamento de dependências e build do projeto.



---

Informações Relevantes

Porta padrão: 8080

Banco de Dados: PostgreSQL

Versão do Java: 17

Estrutura do Projeto:

Model: Representa as entidades do banco de dados.

Repository: Interface para interação com o banco de dados.

Service: Contém a lógica de negócios.

Controller: Gerencia as operações de CRUD.
