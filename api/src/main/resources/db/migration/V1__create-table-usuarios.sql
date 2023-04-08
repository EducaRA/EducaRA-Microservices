CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    codigo UUID UNIQUE NOT NULL DEFAULT gen_random_uuid(),
    nome VARCHAR(30),
    login VARCHAR(30),
    senha VARCHAR(60),
    ativo BOOLEAN
);