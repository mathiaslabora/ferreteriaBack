package com.example.demo.service;

import com.example.demo.DTO.dtoInventario;
import com.example.demo.model.Inventario;
import com.example.demo.repository.InventarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class InventarioService implements dtoInventario {

    @Autowired
    private InventarioRepository inventarioRepository;

    @Override
    public Mono<Inventario> saveInv(Inventario inventario) {
        return this.inventarioRepository.save(inventario);
    }

    @Override
    public Flux<Inventario> findAll() {
        return this.inventarioRepository.findAll();
    }

    @Override
    public Mono<Inventario> findById(String id) {
        return this.inventarioRepository.findById(id);
    }

    @Override
    public Mono<Inventario> updateInv(String id, Inventario inventario){
        return this.inventarioRepository.findById(id)
                .flatMap(fact -> {
                    inventario.setId(id);
                    return saveInv(inventario);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<Inventario> consultaPorArticulo(String articulo){
        return this.inventarioRepository.findByArticulo(articulo)
                .filter(x-> x.getArticulo().equals(articulo))
                .switchIfEmpty(Flux.empty());
    }


    @Override
    public Mono<Inventario> deleteArt(String id){
        return this.inventarioRepository
                .findById(id)
                .flatMap(d-> this.inventarioRepository.deleteById(d.getId()).thenReturn(d));

    }




}
