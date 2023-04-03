package com.educara.api.model.aula;

public record AulaGetAllDto(Long id, String descricao, String codigo, String observacao, String turma) {

    public AulaGetAllDto(Aula aula) {
        this(aula.getId(), aula.getDescricao(), aula.getCodigo(), aula.getObservacao(), aula.getTurma());
    }
}
