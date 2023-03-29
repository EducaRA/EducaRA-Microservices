CREATE TABLE objetos_educacionais (
    id BIGSERIAL PRIMARY KEY,
    size_megabyte INTEGER,
    imagem VARCHAR(200),
    filehash_md5 VARCHAR(32),
    descricao VARCHAR(200),
    extension VARCHAR(5),
    path VARCHAR(200),
    nome VARCHAR(30),
    escala INTEGER,
    fk_aula_id BIGINT,
    FOREIGN KEY (fk_aula_id) REFERENCES aulas (id) ON DELETE RESTRICT
);