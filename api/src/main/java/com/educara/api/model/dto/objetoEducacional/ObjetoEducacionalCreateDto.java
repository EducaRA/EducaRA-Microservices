package com.educara.api.model.dto.objetoEducacional;


import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ObjetoEducacionalCreateDto implements Serializable {
        private String nome;
        private String descricao;
        private String imagem;
        private BigDecimal escala;
        private String filehashMd5;
        private String path;
        private Integer size;
        private String extension;
}
