package com.example.demo.DTO;

import com.example.demo.model.Inventario;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface dtoInventario {

    Mono<Inventario> saveInv(Inventario inventario);

    Flux<Inventario> findAll();

    Mono<Inventario> deleteArt(String id);

    Mono<Inventario> findById(String id);

    Mono<Inventario> updateInv(String id, Inventario inventario);

    Flux<Inventario> consultaPorArticulo(String articulo);
}
