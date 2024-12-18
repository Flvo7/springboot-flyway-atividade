CREATE TABLE cliente (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(150) NOT NULL UNIQUE,
    telefone VARCHAR(15),
    data_cadastro TIMESTAMP NOT NULL
);

