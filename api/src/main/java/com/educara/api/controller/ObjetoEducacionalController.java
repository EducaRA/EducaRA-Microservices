package com.educara.api.controller;

import com.educara.api.model.objetoEducacional.ObjetoEducacionalGetOneDto;
import com.educara.api.model.objetoEducacional.ObjetoEducacionalGetAllDto;
import com.educara.api.model.objetoEducacional.ObjetoEducacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/objetos-educacionais")
public class ObjetoEducacionalController {

    @Autowired
    private ObjetoEducacionalRepository repository;

    @GetMapping
    public ResponseEntity listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable paginacao) {
            var page = repository.findAllByAtivoTrue(paginacao).map(ObjetoEducacionalGetAllDto::new);
            return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var objetoEducacional = repository.getReferenceById(id);
        return ResponseEntity.ok(new ObjetoEducacionalGetOneDto(objetoEducacional));
    }


}
