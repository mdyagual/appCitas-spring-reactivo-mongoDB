package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.tratamientosDTOReactiva;
import com.springBajo8.springBajo8.repository.ItratamientosReactivaRepository;
import com.springBajo8.springBajo8.service.ItratamientosReactivaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class tratamientosReactivaServiceImpl implements ItratamientosReactivaService{

    @Autowired
    private ItratamientosReactivaRepository tratamientosRepo;

    @Override
    public Flux<tratamientosDTOReactiva> findAll() {
        return this.tratamientosRepo.findAll();
    }

    @Override
    public Mono<tratamientosDTOReactiva> findById(String id) {
        return this.tratamientosRepo.findById(id);
    }
    
}
