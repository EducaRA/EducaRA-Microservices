package com.educara.api.model.aula;


public record AulaGetOneDto(Long id, String descricao, String codigo, String observacao, String turma) {

    public AulaGetOneDto(Aula aula) {
        this(aula.getId(), aula.getDescricao(), aula.getCodigo(), aula.getObservacao(), aula.getTurma());
    }
}
