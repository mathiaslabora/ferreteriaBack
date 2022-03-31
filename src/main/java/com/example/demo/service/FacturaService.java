package com.example.demo.service;

import com.example.demo.DTO.dto;
import com.example.demo.model.Facturas;
import com.example.demo.repository.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class FacturaService implements dto {
    @Autowired
    private FacturasRepository facturasRepository;

    @Override
    public Mono<Facturas> saveFact(Facturas facturas) {
        return this.facturasRepository.save(facturas);
    }

    @Override
    public Flux<Facturas> findAll() {
        return this.facturasRepository.findAll();
    }

    @Override
    public Mono<Facturas> findById(String id) {
        return this.facturasRepository.findById(id);
    }

    @Override
    public Mono<Facturas> updateFact(String id, Facturas facturas){
        return this.facturasRepository.findById(id)
                .flatMap(fact -> {
                    facturas.setConsecutivoFactura(id);
                    return saveFact(facturas);
                })
                .switchIfEmpty(Mono.empty());
    }
}
