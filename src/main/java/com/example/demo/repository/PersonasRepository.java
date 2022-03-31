package com.example.demo.repository;

import com.example.demo.model.Inventario;
import com.example.demo.model.Personas;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;


public interface PersonasRepository extends ReactiveMongoRepository<Personas, String> {
    Flux<Personas> findByNombre(String articulo);
}
