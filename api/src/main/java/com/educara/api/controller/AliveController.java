package com.educara.api.controller;

import com.educara.api.model.aula.AulaRepository;
import com.educara.api.model.disciplina.DisciplinaRepository;
import com.educara.api.model.objetoEducacional.ObjetoEducacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AliveController {
    @Autowired
    private ObjetoEducacionalRepository objetoEducacionalRepository;
    @Autowired
    private AulaRepository aulaRepository;
    @Autowired
    private DisciplinaRepository disciplinaRepository;

    @GetMapping
    public ResponseEntity alive() {
        var list = objetoEducacionalRepository.findAll();
        var list2 = aulaRepository.findAll();
        var list3 = disciplinaRepository.findAll();

        return ResponseEntity.ok("ALIVE API" + list.size() + list2.size() + list3.size());
    }

}
