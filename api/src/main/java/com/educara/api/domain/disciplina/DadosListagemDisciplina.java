package com.educara.api.domain.disciplina;

public record DadosListagemDisciplina(Long id, String nome, String sigla, String imagem) {

    public DadosListagemDisciplina(Disciplina disciplina) {
        this(disciplina.getId(), disciplina.getNome(), disciplina.getSigla(), disciplina.getImagem());
    }

}
