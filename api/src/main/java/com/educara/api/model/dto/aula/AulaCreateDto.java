package com.educara.api.model.dto.aula;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AulaCreateDto implements Serializable {
        private String imagem;
        @NotBlank
        private String descricao;
        @NotBlank
        private String codigo;
        @NotBlank
        private String observacao;
        @NotBlank
        private String turma;

}

