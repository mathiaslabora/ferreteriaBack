package com.example.demo.repository;

import com.example.demo.model.Facturas;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;


public interface FacturasRepository extends ReactiveMongoRepository<Facturas, String> {
}
