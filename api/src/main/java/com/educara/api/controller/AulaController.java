package com.educara.api.controller;

import com.educara.api.model.mapper.AulaMapper;
import com.educara.api.repository.AulaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aulas")
public class AulaController {

    @Autowired
    private AulaRepository repository;

    @Autowired
    private AulaMapper mapper;

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10, sort = {"descricao"}) Pageable paginacao) {
        var page = repository.findAllByAtivoTrue(paginacao).map(mapper::toGetAllDto);
            return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var aula = repository.getReferenceById(id);
        return ResponseEntity.ok(mapper.toGetOneDto(aula));
    }


}
