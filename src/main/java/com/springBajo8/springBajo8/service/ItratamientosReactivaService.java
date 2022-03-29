package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;
import com.springBajo8.springBajo8.domain.tratamientosDTOReactiva;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ItratamientosReactivaService {

    Mono<tratamientosDTOReactiva> save(tratamientosDTOReactiva tratamientosDTOReactiva);

    Mono<tratamientosDTOReactiva> delete(String id);

    Mono<tratamientosDTOReactiva> update(String id, padecimientosDTOReactiva padecimientosDTOReactiva);

    Flux<tratamientosDTOReactiva> findByIdTratamiento(String id);

    Flux<tratamientosDTOReactiva> findAll();

    Mono<tratamientosDTOReactiva> findById(String id);
    
}
