package com.educara.api.model.mapper;

import com.educara.api.model.Disciplina;
import com.educara.api.model.dto.disciplina.DisciplinaCreateDto;
import com.educara.api.model.dto.disciplina.DisciplinaGetAllDto;
import com.educara.api.model.dto.disciplina.DisciplinaGetOneDto;
import com.educara.api.model.dto.disciplina.DisciplinaUpdateDto;
import org.mapstruct.Mapper;

@Mapper
public interface DisciplinaMapper {

    Disciplina toEntity(DisciplinaCreateDto dto);
    Disciplina toEntity(DisciplinaUpdateDto dto);
    DisciplinaGetOneDto toGetOneDto(Disciplina disciplina);
    DisciplinaGetAllDto toGetAllDto(Disciplina disciplina);

}
