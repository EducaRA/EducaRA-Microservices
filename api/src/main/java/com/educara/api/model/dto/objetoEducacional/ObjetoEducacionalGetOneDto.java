package com.educara.api.model.dto.objetoEducacional;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

@Getter @Setter
public class ObjetoEducacionalGetOneDto implements Serializable {
        private Long id;
        private String nome;
        private String descricao;
        private String imagem;
        private BigDecimal escala;
        private String filehashMd5;
        private String path;
        private Integer size;
        private String extension;
}
