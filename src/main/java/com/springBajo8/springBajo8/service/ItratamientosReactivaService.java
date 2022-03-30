package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.tratamientosDTOReactiva;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItratamientosReactivaService {


    Flux<tratamientosDTOReactiva> findAll();

    Mono<tratamientosDTOReactiva> findById(String id);
    
}
