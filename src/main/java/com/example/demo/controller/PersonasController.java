package com.example.demo.controller;

import com.example.demo.DTO.dtoPersonas;
import com.example.demo.model.Personas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@CrossOrigin(origins = "*")
@RestController
public class PersonasController {

    @Autowired
    private dtoPersonas dto;

    @PostMapping(value = "/personas")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Personas> saveInv(@RequestBody Personas personas) {
        return this.dto.savePer(personas);
    }

    @GetMapping(value = "/personas")
    private Flux<Personas> findAll() {
        return this.dto.findAll();
    }

    @GetMapping(value = "/personas/{id}")
    private Mono<Personas> findPerById(@PathVariable("id") String id) {
        return this.dto.findById(id);
    }

    @PutMapping(value = "/personas/{id}")
    private Mono<ResponseEntity<Personas>> updateInv(@PathVariable("id") String id, @RequestBody Personas personas) {
        return this.dto.updatePer(id, personas)
                .flatMap(inventario1 -> Mono.just(ResponseEntity.ok(inventario1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/nombreper/{nombre}")
    private Flux<Personas> consultaPorArticulo(@PathVariable("nombre") String nombre){
        return this.dto.consultaPorNombre(nombre);
    }

    @DeleteMapping("/personas/{id}")
    private Mono<ResponseEntity<Personas>>deleteInv(@PathVariable("id") String id){
        return this.dto.deletePer(id)
                .flatMap(personas1 -> Mono.just(ResponseEntity.ok(personas1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


}
