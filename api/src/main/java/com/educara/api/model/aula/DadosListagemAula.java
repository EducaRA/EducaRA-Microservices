package com.educara.api.model.aula;

public record DadosListagemAula(Long id, String descricao, String codigo, String observacao, String turma) {

    public DadosListagemAula(Aula aula) {
        this(aula.getId(), aula.getDescricao(), aula.getCodigo(), aula.getObservacao(), aula.getTurma());
    }
}
