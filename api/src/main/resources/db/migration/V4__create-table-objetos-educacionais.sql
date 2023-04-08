CREATE TABLE objetos_educacionais (
    id BIGSERIAL PRIMARY KEY,
    codigo UUID UNIQUE NOT NULL DEFAULT gen_random_uuid(),
    nome VARCHAR(30),
    descricao VARCHAR(200),
    imagem VARCHAR(200),
    filehash_md5 VARCHAR(32),
    extensao VARCHAR(5),
    caminho VARCHAR(200),
    tamanho_megabyte INTEGER,
    escala INTEGER,
    ativo BOOLEAN,
    fk_aula_id BIGINT,
    FOREIGN KEY (fk_aula_id) REFERENCES aulas (id) ON DELETE RESTRICT
);