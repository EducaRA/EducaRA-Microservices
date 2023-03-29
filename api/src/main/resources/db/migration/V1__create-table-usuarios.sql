CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(30),
    senha VARCHAR(60),
    ativo BOOLEAN
);