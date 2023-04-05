package com.educara.api.model.dto.aula;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class AulaGetAllDto implements Serializable {
    private Long id;
    private String descricao;
    private String codigo;
    private String observacao;
    private String turma;
    private Integer quantidadeObjetos;
}
