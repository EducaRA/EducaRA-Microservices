package com.educara.api.model.disciplina;

import jakarta.validation.constraints.NotBlank;

public record DisciplinaCreateDto(
        @NotBlank
        String nome,
        @NotBlank
        String sigla,
        @NotBlank
        String imagem) {
}
