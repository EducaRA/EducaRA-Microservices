package com.educara.api.controller;

import com.educara.api.repository.ObjetoEducacionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AliveController {
    @Autowired
    private ObjetoEducacionalRepository objetoEducacionalRepository;
    @GetMapping
    public ResponseEntity alive() {
        var list= objetoEducacionalRepository.findAll();

        return ResponseEntity.ok("ALIVE API" + list.size());
    }

}
