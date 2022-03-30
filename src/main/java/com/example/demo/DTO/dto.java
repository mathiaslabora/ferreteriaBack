package com.example.demo.DTO;

import com.example.demo.model.Facturas;
import reactor.core.publisher.Mono;

public interface dto {

    Mono<Facturas> saveFact(Facturas facturas);


}
