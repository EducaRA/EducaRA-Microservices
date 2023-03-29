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