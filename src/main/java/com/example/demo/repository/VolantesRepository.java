package com.example.demo.repository;

import com.example.demo.model.Volantes;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;



public interface VolantesRepository  extends ReactiveMongoRepository<Volantes, String>  {

}
