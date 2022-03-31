package com.example.demo.repository;

import com.example.demo.model.Inventario;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface InventarioRepository extends ReactiveMongoRepository<Inventario, String> {
    Flux<Inventario> findByArticulo(String articulo);
}
