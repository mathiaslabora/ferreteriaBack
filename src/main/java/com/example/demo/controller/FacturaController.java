package com.example.demo.controller;

import com.example.demo.DTO.dto;
import com.example.demo.model.Facturas;
import com.example.demo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "*")
@RestController
public class FacturaController {


    @Autowired
    private dto dto;

    @PostMapping(value = "/ventaconcretada")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Facturas> save(@RequestBody Facturas facturas) {
        return this.dto.saveFact(facturas);
    }

    @GetMapping(value = "/facturas")//para historial de ventas
    private Flux<Facturas> findAll() {
        return this.dto.findAll();
    }

    @GetMapping(value = "/facturas/{id}")
    private Mono<Facturas> findById(@PathVariable("id") String id) {
        return this.dto.findById(id);
    }

    @PutMapping(value = "/facturas/{id}")
    private Mono<ResponseEntity<Facturas>> updateFact(@PathVariable("id") String id, @RequestBody Facturas facturas) {
        return this.dto.updateFact(id, facturas)
                .flatMap(facturas1 -> Mono.just(ResponseEntity.ok(facturas1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }
}
