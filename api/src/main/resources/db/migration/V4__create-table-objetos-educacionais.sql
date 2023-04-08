CREATE TABLE objetos_educacionais (
    id BIGSERIAL PRIMARY KEY,
    codigo UUID UNIQUE NOT NULL DEFAULT gen_random_uuid(),
    size_megabyte INTEGER,
    imagem VARCHAR(200),
    filehash_md5 VARCHAR(32),
    descricao VARCHAR(200),
    extension VARCHAR(5),
    path VARCHAR(200),
    nome VARCHAR(30),
    escala INTEGER,
    ativo BOOLEAN,
    fk_aula_id BIGINT,
    FOREIGN KEY (fk_aula_id) REFERENCES aulas (id) ON DELETE RESTRICT
);