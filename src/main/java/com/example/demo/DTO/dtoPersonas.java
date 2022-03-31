package com.example.demo.DTO;

import com.example.demo.model.Personas;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface dtoPersonas {

    Mono<Personas> savePer(Personas personas);

    Flux<Personas> findAll();

    Mono<Personas> deletePer(String id);

    Mono<Personas> findById(String id);

    Mono<Personas> updatePer(String id, Personas personas);

    Flux<Personas> consultaPorNombre(String personas);
}
