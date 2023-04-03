package com.educara.api.model.disciplina;


public record DisciplinaGetOneDto(
        Long id,
        String nome,
        String sigla,
        String imagem
) {
}
