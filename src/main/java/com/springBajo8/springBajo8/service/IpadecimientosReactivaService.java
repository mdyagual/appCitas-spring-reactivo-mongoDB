package com.springBajo8.springBajo8.service;

import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface IpadecimientosReactivaService {

    Mono<padecimientosDTOReactiva> save(padecimientosDTOReactiva padecimientosDTOReactiva);

    Mono<padecimientosDTOReactiva> delete(String id);

    Mono<padecimientosDTOReactiva> update(String id, padecimientosDTOReactiva padecimientosDTOReactiva);

    Flux<padecimientosDTOReactiva> findByIdPadecimiento(String idPadecimiento);

    Flux<padecimientosDTOReactiva> findAll();

    Mono<padecimientosDTOReactiva> findById(String id);
    
}
