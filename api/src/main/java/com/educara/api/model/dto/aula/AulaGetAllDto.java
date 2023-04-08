package com.educara.api.model.dto.aula;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AulaGetAllDto implements Serializable {
    private Long id;
    private String descricao;
    private UUID codigo;
    private String observacao;
    private String turma;
    private Integer quantidadeObjetos;
}
