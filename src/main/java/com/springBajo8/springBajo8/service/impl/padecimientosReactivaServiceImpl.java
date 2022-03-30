package com.springBajo8.springBajo8.service.impl;

import com.springBajo8.springBajo8.domain.citasDTOReactiva;
import com.springBajo8.springBajo8.domain.padecimientosDTOReactiva;
import com.springBajo8.springBajo8.repository.IpadecimientosReactivaRepository;
import com.springBajo8.springBajo8.service.IpadecimientosReactivaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Stream;

@Service
public class padecimientosReactivaServiceImpl implements IpadecimientosReactivaService{
    @Autowired
    private IpadecimientosReactivaRepository padecimientosRepo;

    @Override
    public Flux<padecimientosDTOReactiva> findAll() {
        return this.padecimientosRepo.findAll();
    }

    @Override
    public Mono<padecimientosDTOReactiva> findById(String id) {
        return this.padecimientosRepo.findById(id);
    }
    
}
