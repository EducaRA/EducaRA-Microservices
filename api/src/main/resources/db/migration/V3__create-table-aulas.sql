CREATE TABLE aulas (
    id BIGSERIAL PRIMARY KEY,
    codigo UUID UNIQUE NOT NULL DEFAULT gen_random_uuid(),
    turma VARCHAR(30),
    descricao VARCHAR(30),
    observacao VARCHAR(300),
    fk_disciplina_id BIGINT,
    fk_professor_id BIGINT,
    ativo BOOLEAN,
    FOREIGN KEY (fk_disciplina_id) REFERENCES disciplinas (id) ON DELETE CASCADE,
    FOREIGN KEY (fk_professor_id) REFERENCES usuarios (id) ON DELETE CASCADE
);