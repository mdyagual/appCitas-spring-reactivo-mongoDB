package com.springBajo8.springBajo8.repository;

import com.springBajo8.springBajo8.domain.tratamientosDTOReactiva;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import reactor.core.publisher.Flux;

public interface ItratamientosReactivaRepository extends ReactiveMongoRepository<tratamientosDTOReactiva, String>{

    Flux<tratamientosDTOReactiva> findByIdTratamiento(String idTratamiento);
    
}
