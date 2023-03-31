package com.educara.api.model.objetoEducacional;

import java.math.BigDecimal;

public record DadosListagemObjetoEducacional(
        Long id,
        String nome,
        String descricao,
        String imagem,
        BigDecimal escala,
        String filehashMd5,
        String path,
        Integer size,
        String extension
) {

    public DadosListagemObjetoEducacional(ObjetoEducacional objetoEducacional) {
        this(objetoEducacional.getId(),
                objetoEducacional.getNome(),
                objetoEducacional.getDescricao(),
                objetoEducacional.getImagem(),
                objetoEducacional.getEscala(),
                objetoEducacional.getFilehashMd5(),
                objetoEducacional.getPath(),
                objetoEducacional.getSize(),
                objetoEducacional.getExtension());
    }
}
