package com.educara.api.model.aula;


public record DadosDetalhamentoAula(Long id, String descricao, String codigo, String observacao, String turma) {

    public DadosDetalhamentoAula(Aula aula) {
        this(aula.getId(), aula.getDescricao(), aula.getCodigo(), aula.getObservacao(), aula.getTurma());
    }
}
