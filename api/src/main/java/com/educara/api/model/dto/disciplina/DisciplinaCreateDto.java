package com.educara.api.model.dto.disciplina;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class DisciplinaCreateDto implements Serializable {

        @NotBlank
        private String nome;
        @NotBlank
        private String sigla;
        @NotBlank
        private String imagem;

        @Size(min = 36, max = 36)
        private UUID codigo;
}
