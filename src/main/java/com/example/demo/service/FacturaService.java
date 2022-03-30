package com.example.demo.service;

import com.example.demo.model.Facturas;
import com.example.demo.repository.FacturasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FacturaService {
    @Autowired
    FacturasRepository facturasRepository;


    public Mono<Facturas> saveFact(Facturas facturas) {
        return facturasRepository.save(facturas);
    }


}
