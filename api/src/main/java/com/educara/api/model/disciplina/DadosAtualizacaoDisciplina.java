package com.educara.api.model.disciplina;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoDisciplina(
        @NotNull
        Long id,
        @NotBlank
        String nome,
        @NotBlank
        String sigla,
        @NotBlank
        String imagem) {
}
