package com.educara.api.model.dto.aula;

import com.educara.api.model.ObjetoEducacional;
import com.educara.api.model.dto.objetoEducacional.ObjetoEducacionalGetOneDto;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
public class AulaGetOneDto implements Serializable {
    private Long id;
    private String descricao;
    private String codigo;
    private String observacao;
    private String turma;
    private List<ObjetoEducacionalGetOneDto> objetos;
}
