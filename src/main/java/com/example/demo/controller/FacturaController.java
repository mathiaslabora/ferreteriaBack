package com.example.demo.controller;

import com.example.demo.DTO.dto;
import com.example.demo.model.Facturas;
import com.example.demo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class FacturaController {


    @Autowired
    private dto dto;

    @PostMapping(value = "/ventaconcretada")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Facturas> save(@RequestBody Facturas facturas) {
        return this.dto.saveFact(facturas);
    }

    @GetMapping(value = "/facturas")
    private Flux<Facturas> findAll() {
        return this.dto.findAll();
    }

}
