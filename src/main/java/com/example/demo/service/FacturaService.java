package com.example.demo.service;

import com.example.demo.DTO.dto;
import com.example.demo.model.Facturas;
import com.example.demo.repository.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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


}
