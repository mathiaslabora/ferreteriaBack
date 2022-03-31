package com.example.demo.service;

import com.example.demo.DTO.dtoPersonas;
import com.example.demo.model.Personas;
import com.example.demo.repository.PersonasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonasService implements dtoPersonas {

    @Autowired
    private PersonasRepository personasRepository;

    @Override
    public Mono<Personas> savePer(Personas personas) {
        return this.personasRepository.save(personas);
    }

    @Override
    public Flux<Personas> findAll() {
        return this.personasRepository.findAll();
    }

    @Override
    public Mono<Personas> findById(String id) {
        return this.personasRepository.findById(id);
    }

    @Override
    public Mono<Personas> updatePer(String id, Personas personas){
        return this.personasRepository.findById(id)
                .flatMap(fact -> {
                    personas.setId(id);
                    return savePer(personas);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Personas> consultaPorNombre(String nombre){
        return this.personasRepository.findByNombre(nombre)
                .filter(x-> x.getNombre().equals(nombre))
                .switchIfEmpty(Flux.empty());
    }


    @Override
    public Mono<Personas> deletePer(String id){
        return this.personasRepository
                .findById(id)
                .flatMap(d-> this.personasRepository.deleteById(d.getId()).thenReturn(d));

    }



}
