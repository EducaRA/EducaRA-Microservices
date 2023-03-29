package com.educara.api.domain.disciplina;

import jakarta.validation.constraints.NotBlank;

public record DadosCadastroDisciplina(
        @NotBlank
        String nome,
        @NotBlank
        String sigla,
        @NotBlank
        String imagem) {
}
