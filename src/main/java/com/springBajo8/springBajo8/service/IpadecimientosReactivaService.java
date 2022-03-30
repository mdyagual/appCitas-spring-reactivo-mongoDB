package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IpadecimientosReactivaService {

    Flux<padecimientosDTOReactiva> findAll();

    Mono<padecimientosDTOReactiva> findById(String id);
    
}
