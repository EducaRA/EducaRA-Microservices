package com.educara.api.controller;

import com.educara.api.model.Disciplina;
import com.educara.api.model.dto.disciplina.DisciplinaCreateDto;
import com.educara.api.model.dto.disciplina.DisciplinaGetAllDto;
import com.educara.api.model.dto.disciplina.DisciplinaUpdateDto;
import com.educara.api.model.mapper.DisciplinaMapper;
import com.educara.api.repository.DisciplinaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;
import java.util.UUID;

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
            Authentication autenticado = SecurityContextHolder.getContext().getAuthentication();
            if(!(autenticado instanceof AnonymousAuthenticationToken)) {
                String emailProfessor = autenticado.getName();
                Page<DisciplinaGetAllDto> page = repository.findAllByAtivoTrueAndProfessor(paginacao, emailProfessor).map(mapper::toGetAllDto);
                return ResponseEntity.ok(page);
            }
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/{codigo}")
    public ResponseEntity detalhar(@PathVariable UUID codigo) {
        var optionalDisciplina = repository.findByCodigo(codigo);
        if(optionalDisciplina.isEmpty())
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(mapper.toGetOneDto(optionalDisciplina.get()));
    }

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DisciplinaCreateDto dto, UriComponentsBuilder uriBuilder) {

        Optional<Disciplina> optional = repository.findByCodigo(dto.getCodigo());
        Disciplina disciplina;

        if(optional.isPresent()){
            disciplina = optional.get();
        }else {
            disciplina = mapper.toEntity(dto);
            repository.save(disciplina);
        }

        var uri = uriBuilder.path("/disciplinas/{codigo}").buildAndExpand(disciplina.getCodigo()).toUri();

        return ResponseEntity.created(uri).body(mapper.toGetOneDto(disciplina));
    }

    @PutMapping(path = {"/{codigo}"})
    @Transactional
    public ResponseEntity atualizar(@PathVariable("codigo") UUID codigo, @RequestBody @Valid DisciplinaUpdateDto dados) {
        var disciplina = repository.findByCodigo(codigo);
        if(disciplina.isEmpty()) return ResponseEntity.notFound().build();
        Disciplina record = mapper.toEntity(dados, disciplina.get());
        repository.save(record);
        return ResponseEntity.ok(mapper.toGetOneDto(record));
    }

    @DeleteMapping("/{codigo}")
    @Transactional
    public ResponseEntity excluir(@PathVariable UUID codigo) {
        var disciplina = repository.findByCodigo(codigo).get();
        disciplina.excluir();
        return ResponseEntity.noContent().build();
    }

}
