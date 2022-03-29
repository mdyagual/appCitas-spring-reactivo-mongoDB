package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;
import com.springBajo8.springBajo8.domain.tratamientosDTOReactiva;
import com.springBajo8.springBajo8.repository.ItratamientosReactivaRepository;
import com.springBajo8.springBajo8.service.ItratamientosReactivaService;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class tratamientosReactivaServiceImpl implements ItratamientosReactivaService{

    @Autowired
    private ItratamientosReactivaRepository tratamientosRepo;

    @Override
    public Mono<tratamientosDTOReactiva> save(tratamientosDTOReactiva tratamientosDTOReactiva) {
        return this.tratamientosRepo.save(tratamientosDTOReactiva);
    }

    @Override
    public Mono<tratamientosDTOReactiva> delete(String id) {
        return this.tratamientosRepo
                .findById(id)
                .flatMap(tratamiento -> this.tratamientosRepo
                                        .deleteById(tratamiento.getId())
                                        .thenReturn(tratamiento));
    }

    @Override
    public Mono<tratamientosDTOReactiva> update(String id, tratamientosDTOReactiva tratamientosDTOReactiva) {
        return this.tratamientosRepo.findById(id)
                .flatMap(tratamiento -> {
                    tratamientosDTOReactiva.setId(id);
                    return save(tratamientosDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());

    }

    @Override
    public Flux<tratamientosDTOReactiva> findByIdTratamiento(String id) {
        return this.tratamientosRepo.findByIdTratamientos(id);
    }

    @Override
    public Flux<tratamientosDTOReactiva> findAll() {
        return this.tratamientosRepo.findAll();
    }

    @Override
    public Mono<tratamientosDTOReactiva> findById(String id) {
        return this.tratamientosRepo.findById(id);
    }
    
}
