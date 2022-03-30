package com.example.demo.controller;

import com.example.demo.model.Facturas;
import com.example.demo.service.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FacturaController {


    @Autowired
    private FacturaService facturaService;

    @PostMapping(value= "/ventaconcretada")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Facturas>save(@RequestBody Facturas facturas){
        return this.facturaService.saveFact(facturas);
    }



}
