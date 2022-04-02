package com.example.demo.controller;

import com.example.demo.DTO.dtoInventario;
import com.example.demo.model.Inventario;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RestController
public class InventarioController {
    @Autowired
    private dtoInventario dto;

    @PostMapping(value = "/articulos")
    @ResponseStatus(HttpStatus.CREATED)
    private Mono<Inventario> saveInv(@RequestBody Inventario inventario) {
        return this.dto.saveInv(inventario);
    }

    @GetMapping(value = "/articulos")
    private Flux<Inventario> findAll() {
        return this.dto.findAll();
    }

    @GetMapping(value = "/articulos/{id}")
    private Mono<Inventario> findArtById(@PathVariable("id") String id) {
        return this.dto.findById(id);
    }

    @PutMapping(value = "/articulos/{id}")
    private Mono<ResponseEntity<Inventario>> updateInv(@PathVariable("id") String id, @RequestBody Inventario inventario) {
        return this.dto.updateInv(id, inventario)
                .flatMap(inventario1 -> Mono.just(ResponseEntity.ok(inventario1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }

    @GetMapping(value = "/nombrearticulo/{articulo}")
    private Flux<Inventario> consultaPorArticulo(@PathVariable("articulo") String articulo) {
        return this.dto.consultaPorArticulo(articulo);
    }

    @DeleteMapping("/articulos/{id}")
    private Mono<ResponseEntity<Inventario>> deleteInv(@PathVariable("id") String id) {
        return this.dto.deleteArt(id)
                .flatMap(inventario1 -> Mono.just(ResponseEntity.ok(inventario1)))
                .switchIfEmpty(Mono.just(ResponseEntity.notFound().build()));
    }


}
