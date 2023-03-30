package com.educara.api.model.disciplina;


public record DadosDetalhamentoDisciplina(Long id, String nome, String sigla, String imagem) {

    public DadosDetalhamentoDisciplina(Disciplina disciplina) {
        this(disciplina.getId(), disciplina.getNome(), disciplina.getSigla(), disciplina.getImagem());
    }
}
