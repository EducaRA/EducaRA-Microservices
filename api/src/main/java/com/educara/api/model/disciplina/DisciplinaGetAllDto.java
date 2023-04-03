package com.educara.api.model.disciplina;

public record DisciplinaGetAllDto(
        Long id,
        String nome,
        String sigla,
        String imagem
) {
}
