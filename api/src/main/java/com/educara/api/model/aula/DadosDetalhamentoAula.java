package com.educara.api.model.aula;


public record DadosDetalhamentoAula(Long id, String nome, String codigo, String observacao, String turma) {

    public DadosDetalhamentoAula(Aula aula) {
        this(aula.getId(), aula.getNome(), aula.getCodigo(), aula.getObservacao(), aula.getTurma());
    }
}
