package com.educara.api.model.dto.disciplina;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class DisciplinaGetOneDto implements Serializable {
        private Long id;
        private String nome;
        private String sigla;
        private String imagem;
}
