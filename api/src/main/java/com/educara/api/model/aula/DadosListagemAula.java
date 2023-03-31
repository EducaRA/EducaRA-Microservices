package com.educara.api.model.aula;

public record DadosListagemAula(Long id, String nome, String codigo, String observacao, String turma) {

    public DadosListagemAula(Aula aula) {
        this(aula.getId(), aula.getNome(), aula.getCodigo(), aula.getObservacao(), aula.getTurma());
    }
}
