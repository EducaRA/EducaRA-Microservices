package com.educara.api.model.mapper;

import com.educara.api.model.ObjetoEducacional;
import com.educara.api.model.dto.objetoEducacional.ObjetoEducacionalCreateDto;
import com.educara.api.model.dto.objetoEducacional.ObjetoEducacionalGetAllDto;
import com.educara.api.model.dto.objetoEducacional.ObjetoEducacionalGetOneDto;
import com.educara.api.model.dto.objetoEducacional.ObjetoEducacionalUpdateDto;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface ObjetoEducacionalMapper {

    ObjetoEducacional toEntity(ObjetoEducacionalCreateDto dto);
    ObjetoEducacional toEntity(ObjetoEducacionalUpdateDto dto, @MappingTarget ObjetoEducacional objetoEducacional);
    ObjetoEducacionalGetOneDto toGetOneDto(ObjetoEducacional objetoEducacional);
    ObjetoEducacionalGetAllDto toGetAllDto(ObjetoEducacional objetoEducacional);

}
