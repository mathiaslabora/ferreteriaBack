package com.example.demo.service;

import com.example.demo.DTO.dtoVolante;
import com.example.demo.model.Volantes;
import com.example.demo.repository.VolantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class VolanteService implements dtoVolante {
    @Autowired
    private VolantesRepository volantesRepository;

    @Override
    public Mono<Volantes> saveVol(Volantes volantes) {
        return this.volantesRepository.save(volantes);
    }

    @Override
    public Flux<Volantes> findAll() {
        return this.volantesRepository.findAll();
    }

    @Override
    public Mono<Volantes> findById(String id) {
        return this.volantesRepository.findById(id);
    }

    @Override
    public Mono<Volantes> updateVol(String id, Volantes volantes){
        return this.volantesRepository.findById(id)
                .flatMap(volantes1 -> {
                    volantes.setIdProveedor(id);
                    return saveVol(volantes);
                })
                .switchIfEmpty(Mono.empty());
    }
}
