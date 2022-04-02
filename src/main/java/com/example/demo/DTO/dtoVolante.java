package com.example.demo.DTO;

import com.example.demo.model.Facturas;
import com.example.demo.model.Volantes;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface dtoVolante {
    Mono<Volantes> saveVol(Volantes volantes);
    Flux<Volantes> findAll();
    Mono<Volantes> findById(String id);
    Mono<Volantes> updateVol(String id, Volantes volantes);

}
