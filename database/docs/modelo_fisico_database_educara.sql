/* modelo_logico_database_educara: */

CREATE TABLE usuarios (
    id BIGSERIAL PRIMARY KEY,
    login VARCHAR(30),
    senha VARCHAR(60)
);

CREATE TABLE disciplinas (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(30),
    sigla VARCHAR(5),
    imagem VARCHAR(300)
);

CREATE TABLE aulas (
    id BIGSERIAL PRIMARY KEY,
    turma VARCHAR(30),
    descricao VARCHAR(30),
    observacao VARCHAR(300),
    codigo UUID,
    fk_disciplina_id BIGINT,
    fk_usuario_id BIGINT,
    FOREIGN KEY (fk_disciplina_id) REFERENCES disciplinas (id) ON DELETE CASCADE,
    FOREIGN KEY (fk_usuario_id) REFERENCES usuarios (id) ON DELETE CASCADE
);

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
