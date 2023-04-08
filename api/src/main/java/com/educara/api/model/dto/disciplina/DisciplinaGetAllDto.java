package com.educara.api.model.dto.disciplina;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class DisciplinaGetAllDto implements Serializable {
        private Long id;
        private String nome;
        private String sigla;
        private String imagem;
}
