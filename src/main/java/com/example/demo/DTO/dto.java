package com.example.demo.DTO;

import com.example.demo.model.Facturas;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface dto {

    Mono<Facturas> saveFact(Facturas facturas);

    Flux<Facturas> findAll();

    Mono<Facturas> findById(String id);

    Mono<Facturas> updateFact(String id, Facturas facturas);

}
