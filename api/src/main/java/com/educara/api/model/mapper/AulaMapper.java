package com.educara.api.model.mapper;

import com.educara.api.model.Aula;
import com.educara.api.model.dto.aula.AulaCreateDto;
import com.educara.api.model.dto.aula.AulaGetAllDto;
import com.educara.api.model.dto.aula.AulaGetOneDto;
import com.educara.api.model.dto.aula.AulaUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AulaMapper {

    Aula toEntity(AulaCreateDto dto);
    Aula toEntity(AulaUpdateDto dto);
    AulaGetOneDto toGetOneDto(Aula aula);

    @Mapping(target = "quantidadeObjetos", expression = "java(aula.getObjetos().size())")
    AulaGetAllDto toGetAllDto(Aula aula);

}
