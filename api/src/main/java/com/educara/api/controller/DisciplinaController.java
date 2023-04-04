package com.educara.api.controller;

import com.educara.api.model.Disciplina;
import com.educara.api.repository.DisciplinaRepository;
import com.educara.api.model.dto.disciplina.DisciplinaCreateDto;
import com.educara.api.model.dto.disciplina.DisciplinaUpdateDto;
import com.educara.api.model.mapper.DisciplinaMapper;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/api/disciplinas")
public class DisciplinaController {

    @Autowired
    private DisciplinaRepository repository;

    @Autowired
    private DisciplinaMapper mapper;


    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
        try {
            var page = repository.findAllByAtivoTrue(paginacao).map(mapper::toGetAllDto);
            return ResponseEntity.ok(page);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DisciplinaCreateDto dto, UriComponentsBuilder uriBuilder) {
        var disciplina = mapper.toEntity(dto);
        repository.save(disciplina);

        var uri = uriBuilder.path("/disciplinas/{id}").buildAndExpand(disciplina.getId()).toUri();

        return ResponseEntity.created(uri).body(mapper.toGetOneDto(disciplina));
    }

    @PutMapping(path = {"/{id}"})
    @Transactional
    public ResponseEntity atualizar(@PathVariable("id") Long id, @RequestBody @Valid DisciplinaUpdateDto dados) {
        var optional = repository.findById(id);
        if(optional.isEmpty())
            return ResponseEntity.notFound().build();
        var disciplina = optional.get();
        Disciplina record = mapper.toEntity(dados);
        repository.save(record);
        return ResponseEntity.ok(mapper.toGetOneDto(record));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var disciplina = repository.getReferenceById(id);
        disciplina.excluir();

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var optionalDisciplina = repository.findById(id);
        if(optionalDisciplina.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.toGetOneDto(optionalDisciplina.get()));
    }


}
