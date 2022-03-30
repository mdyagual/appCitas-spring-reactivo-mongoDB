package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;
import com.springBajo8.springBajo8.repository.IpadecimientosReactivaRepository;
import com.springBajo8.springBajo8.service.IpadecimientosReactivaService;

import org.springframework.beans.factory.annotation.Autowired;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class padecimientosReactivaServiceImpl implements IpadecimientosReactivaService{

    @Autowired
    private IpadecimientosReactivaRepository padecimientosRepo;

    @Override
    public Mono<padecimientosDTOReactiva> save(padecimientosDTOReactiva padecimientosDTOReactiva) {
        return this.padecimientosRepo.save(padecimientosDTOReactiva);
    }

    @Override
    public Mono<padecimientosDTOReactiva> delete(String id) {
        return this.padecimientosRepo
                .findById(id)
                .flatMap(padecimiento -> this.padecimientosRepo
                                            .deleteById(padecimiento.getId())
                                            .thenReturn(padecimiento));
    }

    @Override
    public Mono<padecimientosDTOReactiva> update(String id, padecimientosDTOReactiva padecimientosDTOReactiva) {
        return this.padecimientosRepo.findById(id)
                .flatMap(padecimiento -> {
                    padecimientosDTOReactiva.setId(id);
                    return save(padecimientosDTOReactiva);
                })
                .switchIfEmpty(Mono.empty());
    }

    @Override
    public Flux<padecimientosDTOReactiva> findByIdPadecimiento(String idPadecimiento) {
        return this.padecimientosRepo.findByIdPadecimientos(idPadecimiento);
    }

    @Override
    public Flux<padecimientosDTOReactiva> findAll() {
        return this.padecimientosRepo.findAll();
    }

    @Override
    public Mono<padecimientosDTOReactiva> findById(String id) {
        return this.padecimientosRepo.findById(id);
    }
    
}
