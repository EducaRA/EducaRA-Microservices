package com.educara.api.model.dto.aula;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AulaUpdateDto implements Serializable {
    private String imagem;
    @NotBlank
    private String descricao;
    @NotBlank
    private UUID codigo;
    @NotBlank
    private String observacao;
    @NotBlank
    private String turma;
}
