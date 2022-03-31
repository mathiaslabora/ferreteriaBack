package com.example.demo.controller;

import com.example.demo.DTO.dto;
import com.example.demo.DTO.dtoVolante;
import com.example.demo.model.Volantes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class VolanteController {

    @Autowired
    private dtoVolante dto;

    @PostMapping(value = "/volanteGuardado")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Volantes> save(@RequestBody Volantes volantes) {
        return this.dto.saveVol(volantes);
    }

    @GetMapping(value = "/volantes")//para historial de ventas
    private Flux<Volantes> findAll() {
        return this.dto.findAll();
    }

    @GetMapping(value = "/volantes/{id}")
    private Mono<Volantes> findById(@PathVariable("id") String id) {
        return this.dto.findById(id);
    }

    @PutMapping(value = "/volantes/{id}")
    private Mono<ResponseEntity<Volantes>> updateFact(@PathVariable("id") String id, @RequestBody Volantes volantes) {
        return this.dto.updateVol(id, volantes)
                .flatMap(volantes1 -> Mono.just(ResponseEntity.ok(volantes1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

}
