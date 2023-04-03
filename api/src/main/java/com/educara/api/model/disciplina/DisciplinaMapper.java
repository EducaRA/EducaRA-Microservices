package com.educara.api.model.disciplina;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper
public interface DisciplinaMapper {

    Disciplina toEntity(DisciplinaCreateDto dto);
    Disciplina toEntity(DisciplinaUpdateDto dto);
    DisciplinaGetOneDto toGetOneDto(Disciplina disciplina);
    DisciplinaGetAllDto toGetAllDto(Disciplina disciplina);

}
