CREATE TABLE disciplinas (
    id BIGSERIAL PRIMARY KEY,
    codigo UUID UNIQUE NOT NULL DEFAULT gen_random_uuid(),
    nome VARCHAR(30),
    sigla VARCHAR(5),
    imagem VARCHAR(300),
    ativo BOOLEAN
);