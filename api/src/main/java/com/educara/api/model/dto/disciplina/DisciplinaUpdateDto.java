package com.educara.api.model.dto.disciplina;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class DisciplinaUpdateDto implements Serializable {
        @NotBlank
        private String nome;
        @NotBlank
        private String sigla;
        @NotBlank
        private String imagem;
}
